package cn.mogeek.rmi.ptteng.service.impl;

import cn.mogeek.rmi.ptteng.mapper.BannerMapper;
import cn.mogeek.rmi.ptteng.model.Banner;
import cn.mogeek.rmi.ptteng.model.BannerExample;
import cn.mogeek.rmi.ptteng.service.BannerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BannerServiceImpl
 * @Description 轮播图表 service 实现类
 * @Author owlwinter
 * @Date 2020/6/9 10:50
 * @Version 1.0
 **/
@Service
@CacheConfig(cacheNames = "banner")
public class BannerServiceImpl implements BannerService {
    private static final Logger LOGGER = LogManager.getLogger(BannerServiceImpl.class);

    @Autowired
    BannerMapper bannerMapper;

    /**
      * @Description: 获取首页轮播图
      * @Param: []
      * @return: java.util.List<cn.mogeek.jsptiles.model.Banner>
      * @Author: owlwinter
      * @Date: 2020/6/16
      */
    @Cacheable(key = "#root.method")
    @Override
    public List<Banner> list(){
        LOGGER.info("[bannerList] 没有缓存，重读数据库");

        List<Banner> banners = bannerMapper.selectByExample(new BannerExample());
        return banners;
    }

}
