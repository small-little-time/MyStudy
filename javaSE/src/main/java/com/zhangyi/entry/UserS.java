package com.zhangyi.entry;

import lombok.Data;

import javax.print.attribute.standard.PrinterURI;
import java.util.List;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/3 15:43
 */
@Data
public class UserS {

    private Long id;

    private List<User> users;

    private UserS user;

}
