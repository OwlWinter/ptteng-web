package cn.mogeek.rmi.ptteng.server.util;

import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EmailUtil
 * @Description 测试邮件工具类
 * @Author owlwinter
 * @Date 2020/7/21 9:37
 * @Version 1.0
 **/
@SpringBootTest
public class EmailUtilTest {

    @Autowired
    private EmailUtil emailUtil;

    @Test
    public void testSend() throws MessagingException, IOException, TemplateException {
        String to = "1111111111@qq.com";
        String subject = "验证码";
        Map<String, Object> info = new HashMap<>();

        info.put("username", "username");
        info.put("captcha", "666666");

        emailUtil.send(to, subject, "captcha.ftl", info);
    }

}
