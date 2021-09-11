package com.zhangyi.responsibility;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/8/23 15:23
 */
@Component
public class EmptyHandle implements VerifyHandle {

    @Override
    public List<Object> verify(List<Object> data) {
        System.out.println("非空校验");
        return data;
    }
}
