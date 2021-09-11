package com.zhuanzhuan.tradetraceplat.util;

import java.io.Serializable;

/**
 * @Author: houMedia
 * @Date: 2020/5/21 15:06
 */
@FunctionalInterface
public interface ZzSupplier<T> extends Serializable {
    /**
     * Supplier.get()
     * @return
     * @throws Exception
     */
    T get() throws Exception;
}
