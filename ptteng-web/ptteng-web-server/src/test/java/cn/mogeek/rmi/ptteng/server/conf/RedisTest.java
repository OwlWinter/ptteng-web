package cn.mogeek.rmi.ptteng.server.conf;

import cn.mogeek.rmi.ptteng.model.Banner;
import cn.mogeek.rmi.ptteng.service.BannerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName RedisTest
 * @Description 测试 redis 客户端
 * @Author owlwinter
 * @Date 2020/7/22 0:22
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BannerService bannerService;

    @Test
    public void test(){
        Assert.assertNotNull("bannerService 为空", bannerService);
        redisTemplate.opsForValue().set("bannerList", bannerService.list());
        System.out.println(redisTemplate.opsForValue().get("bannerList"));
    }
}
