package cn.mogeek.rmi.ptteng.service.impl;

import cn.mogeek.rmi.ptteng.model.bo.CaptchaResponse;
import cn.mogeek.rmi.ptteng.server.util.EmailUtil;
import cn.mogeek.rmi.ptteng.server.util.tencent.TencentSmsUtil;
import cn.mogeek.rmi.ptteng.service.CaptchaService;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CaptchaServiceImpl
 * @Description 发送验证码、返回发送状态
 * @Author owlwinter
 * @Date 2020/7/20 17:39
 * @Version 1.0
 **/
@Service
public class CaptchaServiceImpl implements CaptchaService {
    private static final Logger LOGGER = LogManager.getLogger(CaptchaServiceImpl.class);

//    邮箱主题与邮件模板名默认配置
    private static final String SUBJECT = "subject";
    private static final String CAPTCHATEMPLATE = "captchaTemplate";

    private static final long EXPIRATION = 300L;

    /*这里主要是为了获取邮件的额外配置[subject, captchaTemplate], 获取到了就覆盖上面的默认配置* */
    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private TencentSmsUtil smsUtil;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    /**
     * @Description: 邮箱发送验证码
     * @Param: [emailAddress, username]
     * @return: cn.mogeek.rmi.ptteng.model.bo.CaptchaResponse
     * @Author: owlwinter
     * @Date: 2020/7/21
     */
    @Override
    public CaptchaResponse sendEmail(String emailAddress) {
        LOGGER.info("subject:{} captchaTemplate:{}",
                mailProperties.getProperties().getOrDefault(SUBJECT, SUBJECT),
                mailProperties.getProperties().getOrDefault(CAPTCHATEMPLATE, CAPTCHATEMPLATE));

//        获取验证码
        String captcha = randCaptcha();
        Map<String, Object> info = new HashMap<>();
        info.put("captcha", captcha);

//        发送邮件、异常处理
        CaptchaResponse response = new CaptchaResponse();
        response.setContact(emailAddress);
        try {
            emailUtil.send(emailAddress,
                    mailProperties.getProperties().getOrDefault(SUBJECT, SUBJECT),
                    mailProperties.getProperties().getOrDefault(CAPTCHATEMPLATE, CAPTCHATEMPLATE),
                    info);
            response.setStatus("Ok");
            redisTemplate.opsForValue().set(emailAddress, captcha, EXPIRATION, TimeUnit.SECONDS);

            LOGGER.info("验证码邮件发送成功:{}", response);
            // 发送成功返回信息
            return response;
        } catch (MessagingException e) {
            response.setMessage("邮件生成失败");

            LOGGER.error("邮件生成失败:{}", response);
            e.printStackTrace();
        } catch (IOException e) {

            response.setMessage("邮件模板加载失败");
            LOGGER.error("邮件模板加载失败:{}", response);
            e.printStackTrace();
        } catch (TemplateException e) {
            response.setMessage("模板参数有误");

            LOGGER.error("模板参数有误:{}", response);
            e.printStackTrace();
        }

        response.setStatus("Fail");
        //  发送失败返回信息
        return response;
    }

    @Override
    public CaptchaResponse sendSms(String phoneNumber) {
//        获取验证码
        String captcha = randCaptcha();

        CaptchaResponse response = new CaptchaResponse();
        response.setContact(phoneNumber);
        try {
            smsUtil.send(phoneNumber, captcha);
            redisTemplate.opsForValue().set(phoneNumber, captcha, EXPIRATION, TimeUnit.SECONDS);
//            短信发送成功
            response.setStatus("Ok");
        } catch (TencentCloudSDKException e) {
            LOGGER.error("短信发送失败 {}", response);

            response.setStatus("Fail");
            response.setMessage("短信发送失败");
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public boolean checkCaptcha(String key, String captcha) {
        if (redisTemplate.hasKey(key) && captcha.equals(redisTemplate.opsForValue().get(key))){
            redisTemplate.delete(key);
            return true;
        }

        return false;
    }

    /**
     * @Description: 生成 6 位数的验证码
     * @Param: []
     * @return: java.lang.String
     * @Author: owlwinter
     * @Date: 2020/7/20
     */
    private static String randCaptcha(){
        return String.valueOf(100000 + (int) (Math.random() * 900000));
    }
}
