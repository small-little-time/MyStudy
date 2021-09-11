package com.zhuanzhuan.tradetraceplat.traceplat.queryproxy.core;

import com.zhuanzhuan.tradetraceplat.traceplat.queryproxy.entity.InvokeResult;
import lombok.Data;

/**
 * @Author: houMedia
 * @Date: 2021/8/10 15:35
 */
@Data
public class ConvertResult<T> {

    private InvokeResult invokeResult;

    private T convertResult;

}
