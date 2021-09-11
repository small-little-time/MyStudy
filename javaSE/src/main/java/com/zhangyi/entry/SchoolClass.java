package com.zhangyi.entry;

import lombok.Data;

import java.util.List;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/8 10:45
 */
@Data
public class SchoolClass {

    private Integer schoolClassId;

    private String schoolClassName;

    private Teacher teacher;


}
