package com.zhangyi.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/8/22 22:39
 */
@Component
@Slf4j
public class DefaultParkStrategy implements ParkStrategy{
    @Override
    public int calcDistance(int count) {
        log.info("默认公园");
        return 0;
    }
}
