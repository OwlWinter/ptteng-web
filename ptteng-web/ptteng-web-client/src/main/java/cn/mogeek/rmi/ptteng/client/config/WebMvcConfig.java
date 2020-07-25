package cn.mogeek.rmi.ptteng.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName WebMvcConfig
 * @Description servlet 配置类
 * @Author owlwinter
 * @Date 2020/7/19 10:42
 * @Version 1.0
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private CheckInterceptor checkInterceptor;

    /**
     * Override this method to add resource handlers for serving static resources.
     *
     * @param registry
     * @see ResourceHandlerRegistry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * Override this method to add Spring MVC interceptors for
     * pre- and post-processing of controller invocation.
     *
     * @param registry
     * @see InterceptorRegistry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//        注册自定义拦截器
        registry.addInterceptor(checkInterceptor) // 添加拦截器 LoginInterceptor
                .addPathPatterns("/check")
                .order(0); // 拦截器优先级

        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/u/**")
                .order(1);
        super.addInterceptors(registry);
    }
}
