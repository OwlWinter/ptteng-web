package cn.mogeek.rmi.ptteng.service;

import java.util.Map;

public interface DirectionService {
    Map<String, Integer> studentTotalStatus();
    Map<Integer, String> directionMap();
}
