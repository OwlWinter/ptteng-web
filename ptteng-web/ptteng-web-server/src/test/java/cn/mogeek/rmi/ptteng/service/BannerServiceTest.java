package cn.mogeek.rmi.ptteng.service;

import cn.mogeek.rmi.ptteng.model.Banner;
import cn.mogeek.rmi.ptteng.server.PttengWebServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @ClassName BannerServiceTest
 * @Description banner service 测试
 * @Author owlwinter
 * @Date 2020/7/20 4:20
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PttengWebServerApplication.class)
public class BannerServiceTest {

    @Autowired
    private BannerService bannerService;

    @Test
    public void testList(){

        long start = System.currentTimeMillis();
        System.out.println(start);
        for (int i = 0; i < 1000; i++) {
            bannerService.list();
        }
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println(end - start);
    }
}
