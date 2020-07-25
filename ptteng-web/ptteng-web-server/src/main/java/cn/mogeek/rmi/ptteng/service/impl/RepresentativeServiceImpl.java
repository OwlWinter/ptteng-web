package cn.mogeek.rmi.ptteng.service.impl;

import cn.mogeek.rmi.ptteng.mapper.RepresentativeMapper;
import cn.mogeek.rmi.ptteng.model.Representative;
import cn.mogeek.rmi.ptteng.model.RepresentativeExample;
import cn.mogeek.rmi.ptteng.service.RepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RepresentativeServiceImpl
 * @Description 优秀学员表
 * @Author owlwinter
 * @Date 2020/6/9 17:18
 * @Version 1.0
 **/
@CacheConfig(cacheNames = "representative")
@Service
public class RepresentativeServiceImpl implements RepresentativeService {
    @Autowired
    RepresentativeMapper representativeMapper;

    /**
      * @Description: 获取前 4 名优秀学员，按照薪资逆序排列
      * @Param: []
      * @return: java.util.List<cn.mogeek.jsptiles.model.Representative>
      * @Author: owlwinter
      * @Date: 2020/6/16
      */
    @Cacheable(key = "#root.method")
    @Override
    public List<Representative> list(){
        RepresentativeExample example = new RepresentativeExample();
        example.setOrderByClause("`salary` DESC");
        List<Representative> representatives = new ArrayList<>(representativeMapper.selectByExample(example).subList(0, 4));
        return representatives;
    }
}
