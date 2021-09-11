package com.zhangyi.entry;

import com.alibaba.fastjson.JSONObject;
import com.google.common.reflect.TypeToken;
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
    public String password;

    /**年龄*/
    public Long age;

    public Map<String, Long> convert2Map() {
        Type type = new TypeToken<Map<String, Long>>() {}.getType();
        return JSONObject.parseObject(JSONObject.toJSONString(this), type);
    }
}
