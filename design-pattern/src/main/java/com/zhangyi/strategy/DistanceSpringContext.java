package com.zhangyi.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 单例 线程不安全
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/8/22 22:28
 */
@Component
public class DistanceSpringContext {

    @Autowired
    private final Map<String, ParkStrategy> strategyMap = new ConcurrentHashMap<>();

    public ParkStrategy getService(int parkId) {
        ParkEnum parkEnum = ParkEnum.valueOf(parkId);
        return strategyMap.get(parkEnum.getServiceName());
    }
}
