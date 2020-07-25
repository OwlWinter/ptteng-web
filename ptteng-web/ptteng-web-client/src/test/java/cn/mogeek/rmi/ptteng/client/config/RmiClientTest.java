package cn.mogeek.rmi.ptteng.client.config;

import cn.mogeek.rmi.ptteng.model.Banner;
import cn.mogeek.rmi.ptteng.model.LoginUser;
import cn.mogeek.rmi.ptteng.service.BannerService;
import cn.mogeek.rmi.ptteng.service.LoginUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RmiClientTest
 * @Description 测试 RMI
 * @Author owlwinter
 * @Date 2020/7/18 18:13
 * @Version 1.0
 **/
@SpringBootTest
public class RmiClientTest {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private LoginUserService loginUserService;

    @Test
    public void testBannerService(){
//        Assert.notNull(bannerService, "bannerService 为空");
        List<Banner> banners = bannerService.list();
//        for (Banner banner : banners){
//            System.out.print(banner);
//        }
    }

    @Test
    public void testLoginUserService(){
        Assert.notNull(loginUserService, "loginUserService == null");
        LoginUser loginUser = loginUserService.selectByName("phone");
        System.out.println(loginUser);
    }

    @Test
    public void testCheckUser(){
        Assert.notNull(loginUserService, "null");
        boolean status = loginUserService.checkUser("phone", "phonepass");
        System.out.println(status);
    }

    @Test
    public void deepTest(){
        long start = System.currentTimeMillis();
        System.out.println(start);
        for (int i = 0; i < 1000; i++) {
            testBannerService();
        }
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println(end - start);
    }


}
