package cn.mogeek.rmi.ptteng.service;

import cn.mogeek.rmi.ptteng.model.bo.CaptchaResponse;
import cn.mogeek.rmi.ptteng.server.PttengWebServerApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName CaptchaServiceImplTest
 * @Description 测试验证码的发送
 * @Author owlwinter
 * @Date 2020/7/21 17:00
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PttengWebServerApplication.class)
public class CaptchaServiceImplTest {

    @Autowired
    private CaptchaService captchaService;

    @Before
    public void init(){
        Assert.assertNotNull("邮件 service 为空", captchaService);
    }

    @Test
    public void testMail(){
        CaptchaResponse response = captchaService.sendEmail("11111111@qq.com");
        System.out.println(response);
        Assert.assertEquals("Ok", response.getStatus());
    }
}
