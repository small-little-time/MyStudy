package com.zhangyi.entry;

import lombok.Data;

import java.util.List;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/8 10:48
 */
@Data
public class Teacher {

    private String teacherName;

    private List<User> users;

}
