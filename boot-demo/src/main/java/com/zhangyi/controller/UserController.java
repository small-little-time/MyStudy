package com.zhangyi.controller;

import com.alibaba.fastjson.JSON;
import com.zhangyi.entry.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/7 14:45
 */
@RestController
public class UserController {


    @GetMapping("/class")
    public ResponseEntity<Object> test() {
        Object zhangyi = new User("zhangyi", "123", 1L);
        String path = zhangyi.getClass().getResource("").getPath();
        System.out.println(zhangyi.getClass());
        System.out.println(path);
        System.out.println(User.class.getResource("").getPath());
        List<Object> list = new ArrayList<>();
        list.add(path);
        String javaName = zhangyi.getClass().toString();
        String finalName = javaName.substring(javaName.lastIndexOf(".") + 1) + ".java";
        String javaPath = path.replace("target/classes", "src/main/java") + finalName;
        list.add(javaPath);
        return ResponseEntity.ok(list);
    }


    @GetMapping("/object")
    public ResponseEntity<Object> test2() {
        Object zhangyi = new User("zhangyi", "123", 1L);
        return ResponseEntity.ok(zhangyi);
    }

    @GetMapping("/json")
    public ResponseEntity<Object> test3() {
        Object zhangyi = new User("zhangyi", "123", 1L);
        return ResponseEntity.ok(JSON.toJSON(zhangyi));
    }


    @GetMapping("/ip")
    public ResponseEntity<Object> test4() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: " + addr.getHostAddress());
        return ResponseEntity.ok("Local HostAddress: " + addr.getHostAddress());
    }

    @PostMapping("/rt")
    public ResponseEntity<Object> test5(@RequestBody Map<String, Object> map) {
        String a = "{\n" +
                "\t\t\"id\": \"1432616729032263691\",\n" +
                "\t\t\"money\": 123456,\n" +
                "\t\t\"requestInfo\": \"{\\\"ip\\\":\\\"10.136.200.39\\\",\\\"opDesc\\\":\\\"\\u0028ZZShoppingCartService\\u0029IZZShoppingCartService.consumeStock\\u0028String,Long\\u0029\\\",\\\"opName\\\":\\\"zzpostapi\\\"}\"\n" +
                "          \n" +
                "}";
        return ResponseEntity.ok("123");
    }

}
