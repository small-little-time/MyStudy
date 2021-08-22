package com.zhangyi.strategy.strategy;

import com.zhangyi.strategy.ParkStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/8/22 22:26
 */
@Component
@Slf4j
public class PeopleParkStrategy implements ParkStrategy {
    @Override
    public int calcDistance(int count) {
        log.info("人民公园策略");
        return 100 * count;
    }
}
