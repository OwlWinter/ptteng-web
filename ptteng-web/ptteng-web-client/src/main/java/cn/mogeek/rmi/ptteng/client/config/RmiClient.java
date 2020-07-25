package cn.mogeek.rmi.ptteng.client.config;

import cn.mogeek.rmi.ptteng.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

import java.util.List;

/**
 * @ClassName RmiClient
 * @Description RMI 客户端
 * @Author owlwinter
 * @Date 2020/7/18 18:07
 * @Version 1.0
 **/
@Configuration
public class RmiClient {
    private static final Logger LOGGER = LogManager.getLogger(RmiClient.class);

//    @Value("${rmi.client.host}")
//    private List<String> hostList;

    @Value("${rmi.client.host}")
    private String host;

    @Value("${rmi.client.port}")
    private String port;

    @Bean(name = "bannerService")
    public RmiProxyFactoryBean bannerService(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://" + host + ":" + port + "/bannerService");
        rmiProxyFactoryBean.setServiceInterface(BannerService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.setLookupStubOnStartup(false);
        return rmiProxyFactoryBean;
    }

    @Bean(name = "directionService")
    public RmiProxyFactoryBean directionService(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://" + host + ":" + port + "/directionService");
        rmiProxyFactoryBean.setServiceInterface(DirectionService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.setLookupStubOnStartup(false);
        return rmiProxyFactoryBean;
    }

    @Bean(name = "loginUserService")
    public RmiProxyFactoryBean loginUserService(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://" + host + ":" + port + "/loginUserService");
        rmiProxyFactoryBean.setServiceInterface(LoginUserService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.setLookupStubOnStartup(false);
        return rmiProxyFactoryBean;
    }

    @Bean(name = "occupationService")
    public RmiProxyFactoryBean occupationService(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://" + host + ":" + port + "/occupationService");
        rmiProxyFactoryBean.setServiceInterface(OccupationService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.setLookupStubOnStartup(false);
        return rmiProxyFactoryBean;
    }

    @Bean(name = "representativeService")
    public RmiProxyFactoryBean representativeService(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://" + host + ":" + port + "/representativeService");
        rmiProxyFactoryBean.setServiceInterface(RepresentativeService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.setLookupStubOnStartup(false);
        return rmiProxyFactoryBean;
    }

    @Bean(name = "captchaService")
    public RmiProxyFactoryBean captchaService(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://" + host + ":" + port + "/captchaService");
        rmiProxyFactoryBean.setServiceInterface(CaptchaService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.setLookupStubOnStartup(false);
        return rmiProxyFactoryBean;
    }

}
