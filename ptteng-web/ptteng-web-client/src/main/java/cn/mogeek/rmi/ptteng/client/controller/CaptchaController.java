package cn.mogeek.rmi.ptteng.client.controller;

import cn.mogeek.rmi.ptteng.model.bo.CaptchaResponse;
import cn.mogeek.rmi.ptteng.service.CaptchaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName CAPTCHAController
 * @Description 验证码发送控制器，有短信验证码和邮件验证码
 * @Author owlwinter
 * @Date 2020/7/20 17:11
 * @Version 1.0
 **/
@Controller
public class CaptchaController {
    private static final Logger LOGGER = LogManager.getLogger(CaptchaController.class);

    private static final String phoneRegex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
    private static final String mailRegex = "^\\s*\\w*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
//            "^\\\\s*\\\\w+(?:\\\\.{0,1}[\\\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\\\.[a-zA-Z]+\\\\s*$";

    @Autowired
    private CaptchaService captchaService;

    @PostMapping("/register/send")
    public ModelAndView sendCaptcha(@RequestParam String contact){
        ModelAndView modelAndView = new ModelAndView("/json/simple");

        CaptchaResponse response = new CaptchaResponse();
        if (checkRegex(contact, phoneRegex) == true){
            LOGGER.info("发送短信:{}", contact);

            response = captchaService.sendSms(contact);
        } else if (checkRegex(contact, mailRegex) == true){
            LOGGER.info("发送邮箱:{}", contact);

            response = captchaService.sendEmail(contact);
        } else {
            LOGGER.error("联系方式格式错误:{}", contact);

            response.setContact(contact);
            response.setStatus("Fail");
            response.setMessage("CONTCAT FORMAT ERROR");
        }

        modelAndView.addAllObjects(response.getMap());
        return modelAndView;
    }

    /**
     * @Description: 正则匹配
     * @Param: [contact, regex]
     * @return: boolean
     * @Author: owlwinter
     * @Date: 2020/7/24
     */
    private static boolean checkRegex(String contact, String regex){
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(contact);
        return m.matches();
    }
}
