package com.zhangyi.se;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/8/25 14:54
 */
public class Test1 {


    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://test16814.db.zhuaninc.com:23752/dbzz_sc_oms?useUnicode=true&amp;characterEncoding=utf8";
        final String url = jdbcUrl.toLowerCase();
        System.out.println(url.contains(":" + "mysql" + ":"));
    }


}
