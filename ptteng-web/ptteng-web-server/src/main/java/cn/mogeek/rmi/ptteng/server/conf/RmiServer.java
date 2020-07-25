package cn.mogeek.rmi.ptteng.server.conf;

import cn.mogeek.rmi.ptteng.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * @ClassName RmiServer
 * @Description rmi 服务端接口暴露
 * @Author owlwinter
 * @Date 2020/7/20 4:01
 * @Version 1.0
 **/
@Configuration
public class RmiServer {

    @Value("${rmi.server.port}")
    private int port;
    
    @Bean
    public RmiServiceExporter bannerService(BannerService bannerService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("bannerService");
        rmiServiceExporter.setService(bannerService);
        rmiServiceExporter.setServiceInterface(BannerService.class);
        rmiServiceExporter.setServicePort(1201);
        rmiServiceExporter.setRegistryPort(port);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter directionService(DirectionService directionService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("directionService");
        rmiServiceExporter.setService(directionService);
        rmiServiceExporter.setServiceInterface(DirectionService.class);
        rmiServiceExporter.setServicePort(1202);
        rmiServiceExporter.setRegistryPort(port);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter loginUserService(LoginUserService loginUserService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("loginUserService");
        rmiServiceExporter.setService(loginUserService);
        rmiServiceExporter.setServiceInterface(LoginUserService.class);
        rmiServiceExporter.setServicePort(1203);
        rmiServiceExporter.setRegistryPort(port);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter occupationService(OccupationService occupationService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("occupationService");
        rmiServiceExporter.setService(occupationService);
        rmiServiceExporter.setServiceInterface(OccupationService.class);
        rmiServiceExporter.setServicePort(1204);
        rmiServiceExporter.setRegistryPort(port);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter representativeService(RepresentativeService representativeService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("representativeService");
        rmiServiceExporter.setService(representativeService);
        rmiServiceExporter.setServiceInterface(RepresentativeService.class);
        rmiServiceExporter.setServicePort(1205);
        rmiServiceExporter.setRegistryPort(port);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter captchaService(CaptchaService captchaService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("captchaService");
        rmiServiceExporter.setService(captchaService);
        rmiServiceExporter.setServiceInterface(CaptchaService.class);
        rmiServiceExporter.setServicePort(1206);
        rmiServiceExporter.setRegistryPort(port);
        return rmiServiceExporter;
    }
}
