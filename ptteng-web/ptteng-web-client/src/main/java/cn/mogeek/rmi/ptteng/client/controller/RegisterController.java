package cn.mogeek.rmi.ptteng.client.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName SignOnController
 * @Description 注册控制器
 * @Author owlwinter
 * @Date 2020/7/20 15:00
 * @Version 1.0
 **/
@Controller
@RequestMapping("/register")
public class RegisterController {
    private static final Logger LOGGER = LogManager.getLogger(RegisterController.class);

    /**
     * @Description: 跳转到邮件注册页面
     * @Param: []
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: owlwinter
     * @Date: 2020/7/21
     */
    @GetMapping("/mail")
    public ModelAndView toMailPage(){
        ModelAndView modelAndView = new ModelAndView("contact");
        modelAndView.addObject("title", "葡萄藤 | 用户注册");
        modelAndView.addObject("body", "/page/signonEmail");
        modelAndView.addObject("settime", System.currentTimeMillis());
        return modelAndView;
    }

    /**
     * @Description: 跳转到手机注册页面
     * @Param: []
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: owlwinter
     * @Date: 2020/7/21
     */
    @GetMapping("/sms")
    public ModelAndView toSmsPage(){
        ModelAndView modelAndView = new ModelAndView("contact");
        modelAndView.addObject("title", "葡萄藤 | 用户注册");
        modelAndView.addObject("body", "/page/signonSms");
        modelAndView.addObject("settime", System.currentTimeMillis());
        return modelAndView;
    }



}
