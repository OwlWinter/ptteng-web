package cn.mogeek.rmi.ptteng.client.controller;

import cn.mogeek.rmi.ptteng.client.util.UserToken;
import cn.mogeek.rmi.ptteng.model.LoginUser;
import cn.mogeek.rmi.ptteng.service.LoginUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description 登录控制器
 * @Author owlwinter
 * @Date 2020/7/18 22:20
 * @Version 1.0
 **/
@Controller
public class LoginController {
    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @Autowired
    private LoginUserService loginUserService;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(required = false) String call_back, ModelAndView modelAndView){
        LOGGER.info("====> [/login]");

        modelAndView.setViewName("contact");
        modelAndView.addObject("title", "葡萄藤 | 用户登录");
        modelAndView.addObject("body", "/page/login");
        modelAndView.addObject("settime", System.currentTimeMillis());

        if (call_back != null) { modelAndView.addObject("call_back", call_back); }

        return modelAndView;
    }

    @PostMapping("/check")
    public ModelAndView check(@RequestParam("username") String key,
                              @RequestParam("password") String password,
                              @RequestParam(required = false, defaultValue = "/home") String call_back,
                              HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("redirect:" + call_back);
        LOGGER.info("====> [/check]");
        LOGGER.info("登录请求 key:{} password:{} call_back:{}", key, password, call_back);

//        获取用户信息
        LoginUser loginUser = loginUserService.selectByName("phone");

//        构建 token
        Map<String, Object> info = new HashMap<>();
        info.put("username", loginUser.getName());
        info.put("logo", loginUser.getHead());
        modelAndView.addObject("token", UserToken.generator(info));

        LOGGER.info("<==== [/chack]");

        return modelAndView;
    }

    @GetMapping("/logout")
    public String toLogOut(){
        return "forward:home";
    }
}
