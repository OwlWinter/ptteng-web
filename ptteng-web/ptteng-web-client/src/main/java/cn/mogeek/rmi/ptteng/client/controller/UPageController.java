package cn.mogeek.rmi.ptteng.client.controller;

import cn.mogeek.rmi.ptteng.service.OccupationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName UPageController
 * @Description 需要登录才能访问
 * @Author owlwinter
 * @Date 2020/7/18 21:10
 * @Version 1.0
 **/
@Controller
@RequestMapping("/u")
public class UPageController {
    private static final Logger LOGGER = LogManager.getLogger(UPageController.class);

    @Autowired
    private OccupationService occupationService;

    @GetMapping("/occupation")
    public ModelAndView uPage(ModelAndView modelAndView){
        LOGGER.info("====> [/u/occupation]");

        modelAndView.setViewName("contact");
        modelAndView.addObject("title", "葡萄藤 | 职业详情");
        modelAndView.addObject("body", "/page/occupation");
        modelAndView.addObject("occupation", occupationService.listMap());
        modelAndView.addObject("settime", System.currentTimeMillis());
        return modelAndView;
    }
}
