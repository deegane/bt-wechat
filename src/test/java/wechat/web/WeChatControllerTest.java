package wechat.web;

import com.google.common.io.Files;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeChatControllerTest {

    @Autowired
    private WeChatController weChatController;


    @Test
    public void test() {
        DateTime now = DateTime.now().withSecondOfMinute(0);

        System.out.println(now);
    }

    @Test
    public void prime() {

        for (int i = 1; i <= 100; i++) {

            for (int j = 1; j <= i; j++) {

                int remainder = j % i;

                if (remainder == 0 && j != i) {
                    System.out.println(i);
                }
            }
        }
    }



    //@Test
    public void testPost() throws IOException {
        String postXML = getXml("post.xml");
        weChatController.receiveMessage(postXML);
    }

    private String getXml(String fileName) throws IOException {
        Resource resource = new ClassPathResource("data/"+fileName);
        return Files.toString(resource.getFile(), Charset.defaultCharset());
    }
}