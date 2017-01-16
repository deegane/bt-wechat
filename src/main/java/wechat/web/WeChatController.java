package wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wechat.domain.Profile;
import wechat.domain.TextMessage;
import wechat.util.Util;

import java.util.Date;

@RestController
@RequestMapping("wechat")
public class WeChatController {

    @Autowired
    private Util util;

    @RequestMapping(method = RequestMethod.GET)
    public String validate(
            @RequestParam(value="signature") String signature,
            @RequestParam(value="timestamp") String timestamp,
            @RequestParam(value="nonce") String nonce,
            @RequestParam(value="echostr") String echostr) {

        if(util.validateAuth(signature,timestamp,nonce)) {
            return echostr;
        }
       return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String receiveMessage(@RequestBody String requestBody)  {

        try {
            TextMessage from = util.convertXML(requestBody);
            System.out.println("from:"+from.toString());

            Profile profile = util.getProfile(from.fromUserName);

            TextMessage to = this.toMsg(from, profile);
            return util.convertToXml(to);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private TextMessage toMsg(TextMessage from, Profile profile) {
        TextMessage to = new TextMessage();
        to.toUserName = from.fromUserName;
        to.fromUserName = from.toUserName;
        to.createTime = String.valueOf(new Date().getTime());
        to.msgType = "text";

        if(from.msgType.equals("event")) {

            if (profile.getNickname() != null) {
                to.content = "Hello " + profile.getNickname()
                        + ".\nI retrieved your profile from your OpenID:" + from.fromUserName
                        + ".\n"
                        + "\nPlease click www.brandtone.ie for more information";
            } else {
                to.content = "Error retrieving your information";
            }
        } else if (from.msgType.equals("text")) {
            to.content="Please click www.brandtone.ie for more information";
        }

        to.msgId = from.msgId;

        System.out.println(to);
        return to;
    }
}