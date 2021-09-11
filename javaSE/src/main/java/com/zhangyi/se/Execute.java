package com.zhangyi.se;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/3 10:23
 */
public class Execute<T> {

    public static <T> Execute<T> execute(ZzSupplier<T> zzSupplier) {
        try {
            T t = zzSupplier.get();
            System.out.println(t);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
