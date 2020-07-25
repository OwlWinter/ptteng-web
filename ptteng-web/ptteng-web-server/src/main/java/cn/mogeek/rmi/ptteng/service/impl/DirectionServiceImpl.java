package cn.mogeek.rmi.ptteng.service.impl;

import cn.mogeek.rmi.ptteng.mapper.DirectionMapper;
import cn.mogeek.rmi.ptteng.model.Direction;
import cn.mogeek.rmi.ptteng.model.DirectionExample;
import cn.mogeek.rmi.ptteng.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DirectionServiceImpl
 * @Description 职业方向表的 service 实现类
 * @Author owlwinter
 * @Date 2020/6/9 16:26
 * @Version 1.0
 **/
@Service
@CacheConfig(cacheNames = "direction")
public class DirectionServiceImpl implements DirectionService {
    @Autowired
    DirectionMapper directionMapper;

    /**
      * @Description: 返回首页所需要的在学人数与就业人数信息
      * @Param: []
      * @return: java.util.Map<java.lang.String,java.lang.Integer>
      * @Author: owlwinter
      * @Date: 2020/6/16
      */
    @Cacheable(key = "#root.method")
    @Override
    public Map<String, Integer> studentTotalStatus(){
        // final String directionServiceImplStudentTotalStatus = "DirectionServiceImpl_studentTotalStatus";
        List<Direction> directions = directionMapper.selectByExample(new DirectionExample());
        Integer total =  0, employment = 0;
        for (Direction d :
                directions) {
            total += d.getNumberOfStudent();
            employment += d.getEmployedPopulation();
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("total", total);
        result.put("employment", employment);
        return result;
    }

    /**
      * @Description: 获取职业方向 id 映射结果集
      * @Param: []
      * @return: java.util.Map<java.lang.Integer,java.lang.String>
      * @Author: owlwinter
      * @Date: 2020/6/16
      */
    @Cacheable(key = "#root.method")
    @Override
    public Map<Integer, String> directionMap(){
        Map<Integer, String> integerStringMap = new LinkedHashMap<>();
        List<Direction> directionList = directionMapper.selectByExample(new DirectionExample());
        for (Direction d :
                directionList) {
            integerStringMap.put(d.getId(), d.getCareerDirection());
        }

        return  integerStringMap;
    }
}
