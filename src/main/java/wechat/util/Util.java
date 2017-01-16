package wechat.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import wechat.domain.AccessToken;
import wechat.domain.Profile;
import wechat.domain.TextMessage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Past POC functionality this would be refactored
 */
@Component
public class Util implements ApplicationListener<ContextRefreshedEvent> {

    private RestTemplate restTemplate = new RestTemplate();

    private String baseUrl = "https://api.wechat.com/cgi-bin";

    private String token = "wechat123";
    private String appId = "wx8b422872703cce40";
    private String secret = "e19c6a87ce7e23375687532acd5ea6b5";

    private String accessTokenString = "loaded onApplicationEvent";

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        updateAccessToken();
    }

    public boolean validateAuth(String signature, String timestamp,
                                String nonce) {

        String excepted = hash(getStringToHash(timestamp, nonce,
                token));

        if(signature == null || !signature.equals(excepted)) {
            return false;
        }

        return true;
    }

    private String getStringToHash(String timestamp, String nonce,
                                            String token) {
        List<String> list = new ArrayList<>();
        list.add(timestamp);
        list.add(nonce);
        list.add(token);

        String result = "";
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }

    private String hash(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] b = md.digest(str.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // never happens
        }
        return null;
    }

    public TextMessage convertXML(String xml) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(TextMessage.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        TextMessage textMessage = (TextMessage) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        return textMessage;
    }

    public String convertToXml(TextMessage textMessage) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(TextMessage.class);
        Marshaller jaxbmarshaller = jaxbContext.createMarshaller();

        StringWriter sw = new StringWriter();
        jaxbmarshaller.marshal(textMessage, sw);
        return sw.toString();
    }

    public Profile getProfile(String openId) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/user/info")
            .queryParam("access_token", accessTokenString)
            .queryParam("openid", openId)
            .queryParam("lang", "en_US");

        Profile profile =  restTemplate.getForObject(builder.toUriString(), Profile.class);

        if(profile.getNickname()==null) {
            updateAccessToken();
            profile = restTemplate.getForObject(builder.toUriString(), Profile.class);
        }
        return profile;
    }

    private void updateAccessToken() {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/token")
                .queryParam("grant_type", "client_credential")
                .queryParam("appid",appId)
                .queryParam("secret",secret);

        AccessToken accessToken = restTemplate.getForObject(builder.toUriString(), AccessToken.class);
        accessTokenString = accessToken.getAccessToken();
        System.out.println("updating Access Token:"+accessTokenString);
    }
}