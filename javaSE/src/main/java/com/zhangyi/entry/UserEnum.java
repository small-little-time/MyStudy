package com.zhangyi.entry;

import lombok.*;

import java.util.function.Function;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/2 15:43
 */
@AllArgsConstructor
@Getter
@ToString
public enum UserEnum {


    NULL(0, "null", "null", User::getAge),
    ZHANGYI(1, "zhangyi", "zhanghyi", User::getUsername);

    private Integer type;

    private String username;


    private String password;


    private Function<User, Object> function;

    public static UserEnum of(Integer type) {
        for (UserEnum value : values()) {
            if (value.getType().equals(type)) {
                return value;
            }
        }
        return null;
    }

}
