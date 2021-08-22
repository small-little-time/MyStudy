package com.zhangyi.strategy;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/8/22 22:24
 */
public interface ParkStrategy {
    /**
     * 计算距离
     * @param count
     * @return
     */
    int calcDistance(int count);
}
