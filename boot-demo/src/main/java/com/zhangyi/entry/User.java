package com.zhangyi.entry;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/1 11:06
 */
@Data
@AllArgsConstructor
public class User {

    /**
     * 张仪
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Long age;


}
