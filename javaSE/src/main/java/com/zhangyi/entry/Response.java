package com.zhangyi.entry;

import lombok.Data;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/8 10:42
 */
@Data
public class Response<T> {


    private Boolean success;

    private T data;

}
