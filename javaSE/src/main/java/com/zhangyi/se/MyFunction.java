package com.zhangyi.se;

import java.io.Serializable;

/**
 * 功能描述:
 * 函数式接口,获取字段名
 * @author zhangxzh
 * @date 2019/12/19
 */
@FunctionalInterface
public interface MyFunction<T, R> extends Serializable {

    /**
     * 定义使用
     * @param t
     * @return
     */
    R apply(T t);
}
