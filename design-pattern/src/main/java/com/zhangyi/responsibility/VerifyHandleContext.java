package com.zhangyi.responsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/8/23 15:25
 */
@Component
public class VerifyHandleContext {

    @Autowired
    private List<VerifyHandle> verifyHandleList;

    public List<Object> verifyData(List<Object> data) {
        List<Object> res = null;
        for (VerifyHandle verifyHandle : verifyHandleList) {
            res = verifyHandle.verify(data);
        }
        return res;
    }


}
