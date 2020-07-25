package cn.mogeek.rmi.ptteng.client.controller;

import cn.mogeek.rmi.ptteng.client.util.UserToken;
import cn.mogeek.rmi.ptteng.service.BannerService;
import cn.mogeek.rmi.ptteng.service.DirectionService;
import cn.mogeek.rmi.ptteng.service.RepresentativeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName HomeController
 * @Description 主页控制器
 * @Author owlwinter
 * @Date 2020/7/18 17:11
 * @Version 1.0
 **/
@Controller
public class HomeController {
    private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

    @Autowired
    private BannerService bannerService;

    @Autowired
    private DirectionService directionService;

    @Autowired
    private RepresentativeService representativeService;

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView, @RequestParam(required = false) String token) throws JsonProcessingException, IOException {
        LOGGER.info("====> [/home]");

        modelAndView.setViewName("contact");
        modelAndView.addObject("title", "葡萄藤 | 首页");
        modelAndView.addObject("body", "/page/home");
        modelAndView.addObject("bannerList", bannerService.list());
        modelAndView.addObject("statistics", directionService.studentTotalStatus());
        modelAndView.addObject("representatives", representativeService.list());
        modelAndView.addObject("settime", System.currentTimeMillis());
        if (token != null) {
            modelAndView.addObject("token", token);

//            解析 token 明文部分并且添加到视图中，前端会读取
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> info = mapper.readValue(UserToken.parser(token), Map.class);
            modelAndView.addAllObjects(info);
        }

        return modelAndView;
    }

    @GetMapping("/")
    public String toHome(){
        LOGGER.info("<===> [/] forward:/home");

        return "forward:home";
    }
}
