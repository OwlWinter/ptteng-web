package cn.mogeek.rmi.ptteng.service.impl;

import cn.mogeek.rmi.ptteng.mapper.OccupationMapper;
import cn.mogeek.rmi.ptteng.model.OccupationExample;
import cn.mogeek.rmi.ptteng.service.DirectionService;
import cn.mogeek.rmi.ptteng.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName OccupationServiceImpl
 * @Description 职业细分表的 service 实现类
 * @Author owlwinter
 * @Date 2020/6/9 18:45
 * @Version 1.0
 **/
@CacheConfig(cacheNames = "occupation")
@Service
public class OccupationServiceImpl implements OccupationService {
    @Autowired
    OccupationMapper occupationMapper;

    @Autowired
    DirectionService directionService;

    /**
      * @Description: 获取细分职业，按照职业方向归类
      * @Param: []
      * @return: java.util.Map<java.lang.String,java.util.List>
      * @Author: owlwinter
      * @Date: 2020/6/16
      */
    @Cacheable(key = "#root.method")
    @Override
    public Map<String, List> listMap(){
        Map<Integer, String> integerStringMap = directionService.directionMap();
        //List<Occupation> occupationList = occupationMapper.selectByExample(new OccupationExample());
        Map<String, List> stringListMap = new LinkedHashMap<>();
        OccupationExample occupationExample = new OccupationExample();
        Set<Integer> idSet = integerStringMap.keySet();
        Iterator<Integer> integerIterator = idSet.iterator();
        while (integerIterator.hasNext()){
            occupationExample.clear();
            int career_direction = integerIterator.next();
            occupationExample.createCriteria().andCareerDirectionEqualTo(career_direction);
            stringListMap.put(integerStringMap.get(career_direction), occupationMapper.selectByExample(occupationExample));
        }
        return stringListMap;
    }
}
