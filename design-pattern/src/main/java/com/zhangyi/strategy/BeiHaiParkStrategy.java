package com.zhangyi.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/** 北海公园
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/8/22 22:26
 */
@Component
@Slf4j
public class BeiHaiParkStrategy implements  ParkStrategy{
    @Override
    public int calcDistance(int count) {
        log.info("北海公园策略");
        return 10*count;
    }
}
