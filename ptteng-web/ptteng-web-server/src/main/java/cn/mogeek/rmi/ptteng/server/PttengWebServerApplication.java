package cn.mogeek.rmi.ptteng.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "cn.mogeek")
@MapperScan(basePackages = {"cn.mogeek.rmi.ptteng.mapper"})
public class PttengWebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PttengWebServerApplication.class, args);
    }

}
