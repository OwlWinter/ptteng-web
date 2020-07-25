package cn.mogeek.rmi.ptteng.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan("cn.mogeek")
public class PttengWebClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PttengWebClientApplication.class, args);
    }

}
