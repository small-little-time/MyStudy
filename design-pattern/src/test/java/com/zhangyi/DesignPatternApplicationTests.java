package com.zhangyi;

import com.zhangyi.strategy.DistanceSpringContext;
import com.zhangyi.strategy.ParkStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignPatternApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private DistanceSpringContext distanceSpringContext;

    @Test
    public void  ParkStrategyTest(){
        ParkStrategy beiHaiParkStrategy = distanceSpringContext.getService(2);
        System.out.println(beiHaiParkStrategy.calcDistance(10));

    }

}
