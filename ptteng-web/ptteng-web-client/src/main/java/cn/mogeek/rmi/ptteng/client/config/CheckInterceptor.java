package cn.mogeek.rmi.ptteng.client.config;

import cn.mogeek.rmi.ptteng.service.LoginUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description 校验用户账户密码、插入个人信息到页面
 * @Author owlwinter
 * @Date 2020/7/19 10:37
 * @Version 1.0
 **/
@Component
public class CheckInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LogManager.getLogger(CheckInterceptor.class);

    @Autowired
    private LoginUserService loginUserService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String call_back = request.getParameter("call_back");

        LOGGER.info("==> [preHandle] call_back:{}", call_back);

        String key = request.getParameter("username");
        String password = request.getParameter("password");

        LOGGER.info("key:{} password:{}", key, password);

        if (loginUserService.checkUser(key, password) == true){
            LOGGER.info("<== [preHandle] 用户校验通过");

            return true;
        }

        LOGGER.info("<== [preHandle] redirect:{}", "/login");

        response.sendRedirect("/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("<=> [postHandle]");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
