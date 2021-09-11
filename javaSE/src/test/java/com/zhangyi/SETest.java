package com.zhangyi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.google.common.collect.Lists;
import com.zhangyi.entry.*;
import com.zhangyi.se.Execute;
import com.zhangyi.se.SerializedLambda;
import com.zhangyi.se.ZzSupplier;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/1 11:11
 */
public class SETest {


    @Test
    public void test1() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("" + addr.getHostAddress());
        String s = "" + addr.getHostAddress();
        System.out.println(s);
    }

    @Test
    public void test2() {
        String columnName = SerializedLambda.getColumnName(User::getUsername);
        System.out.println(columnName);
    }


    @Test
    public void test3() {
        User u1 = new User("zhangyi", "123", 1L);
        User u2 = new User("zhangyi", "123", 2L);
        User u3 = new User("zhangyi", "123", 3L);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        List<Long> list1 = list.stream().map(User::getAge).collect(Collectors.toList());


    }

    @Test
    public void test4() {
        UserEnum of0 = UserEnum.of(0);
        UserEnum of1 = UserEnum.of(1);
        User u1 = new User("zhangyi", "123", 1L);
        Object apply = of0.getFunction().apply(u1);
        Object apply2 = of1.getFunction().apply(u1);
        System.out.println(apply);
        System.out.println(apply2);

    }

    @Test
    public void test5() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.zhangyi.se.Test1");
        Execute.execute(() -> Class.forName("com.zhangyi.se.Test1"));
    }

    @Test
    public void test6() {
        User u1 = new User("zhangyi", "123", 1L);
        User u2 = new User("zy", "123312", 23L);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        UserS userS = new UserS();
        userS.setUsers(list);
        userS.setId(12222L);
        Map<String, Object> paths = JSONPath.paths(userS);
        System.out.println(paths);
        System.out.println(paths.get("/"));
//        System.out.println(paths);
    }

    @Test
    public void test7() throws NoSuchFieldException, IllegalAccessException {
        String a = "/data/orderList/0/name";
        System.out.println(a.substring(a.lastIndexOf("/") + 1));
        User zhangyi = new User("zhangyi", "123", 1L, Long.class);
        Class typeClass = zhangyi.getClassType();
        Field field = zhangyi.getClass().getDeclaredField("age");
        field.setAccessible(true);
        if (Long.class == typeClass) {
            field.set(zhangyi, Long.valueOf("123"));
        } else if (String.class == typeClass) {
            field.set(zhangyi, "123");
        }
        System.out.println(zhangyi);
    }

    @Test
    public void test8() {
        Object zhangyi = new User("zhangyi", "123", 1L);
        String path = zhangyi.getClass().getResource("").getPath();
        System.out.println(zhangyi.getClass());
        System.out.println(path);
        System.out.println(User.class.getResource("").getPath());
        System.out.println("D:/code/IdeaCode/MyStudy/javaSE/src/main/java/com/zhangyi/entry/User.java");
        String javaName = zhangyi.getClass().toString();
        String finalName = javaName.substring(javaName.lastIndexOf(".") + 1) + ".java";
        String javaPath = path.replace("target/classes", "src/main/java") + finalName;
        System.out.println(javaPath);
    }


    @Test
    public void jsonPathTest() {
        Response<List<SchoolClass>> schoolClassResponse = new Response<>();
        schoolClassResponse.setSuccess(true);
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setSchoolClassName("班级名");
        schoolClass.setSchoolClassId(1);

        Teacher teacher = new Teacher();
        teacher.setTeacherName("老师");
        schoolClass.setTeacher(teacher);
        User u1 = new User("zhangyi", "123", 1L);
        User u2 = new User("zy", "123312", 23L);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        teacher.setUsers(list);
        schoolClassResponse.setData(Collections.singletonList(schoolClass));

        Map<String, Object> paths = JSONPath.paths(schoolClassResponse);
        String filter = "/data/0/teacher/users";
        Object o = paths.get(filter);
        System.out.println(JSON.toJSONString(o));
        Map<String, Object> newPath = JSONPath.paths(o);
        Object o1 = paths.get(filter + "/0");
        Object o2 = JSON.toJSON(o1);
        System.out.println(paths);
    }


    @Test
    public void test9() {
        String a = "{\n" +
                "\t\t\"id\": \"1432616729032263691\",\n" +
                "\t\t\"money\": 123456,\n" +
                "\t\t\"requestInfo\": \"{\\\"ip\\\":\\\"10.136.200.39\\\",\\\"opDesc\\\":\\\"\\u0028ZZShoppingCartService\\u0029IZZShoppingCartService.consumeStock\\u0028String,Long\\u0029\\\",\\\"opName\\\":\\\"zzpostapi\\\"}\"\n" +
                "          \n" +
                "}";

        Object o = JSON.parse(a);
        Map<String, Object> paths = JSONPath.paths(o);
        System.out.println(paths);
        System.out.println(paths.get("/id") instanceof String);
        System.out.println(paths.get("/requestInfo") instanceof String);
        if (paths.get("/id") instanceof String) {
            Object object = JSON.parse((String) paths.get("/id"));
            if (object instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) object;
                System.out.println("====object=====");
                System.out.println(jsonObject);
            } else if (object instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) object;
                System.out.println("====array=====");
                System.out.println(jsonArray);
            }
        }
        System.out.println(paths.get("/id"));
    }


    @Test
    public void test10() {
        String a = "{\"brandId\":\"0\",\"brandIdNew\":10530,\"cateTemplateId\":7373,\"extraInfo\":\"{\\\"shortTitle\\\":\\\"苹果 暗夜绿色\\\"}\",\"modelId\":2192,\"params\":\"[{\\\"paramId\\\":5587,\\\"valueId\\\":\\\"1084995\\\"},{\\\"paramId\\\":7191,\\\"valueId\\\":\\\"1093559\\\"},{\\\"paramId\\\":6652,\\\"valueId\\\":\\\"720002\\\"},{\\\"paramId\\\":7300,\\\"valueId\\\":\\\"213899751\\\"},{\\\"paramId\\\":6977,\\\"valueId\\\":\\\"1080626\\\"},{\\\"paramId\\\":6651,\\\"valueId\\\":\\\"511434\\\"}]\",\"paramsNew\":\"[{\\\"paramId\\\":6652,\\\"valueId\\\":\\\"1080628\\\"},{\\\"paramId\\\":5587,\\\"valueId\\\":\\\"1084995\\\"},{\\\"paramId\\\":7191,\\\"valueId\\\":\\\"1093559\\\"},{\\\"paramId\\\":7300,\\\"valueId\\\":\\\"213899751\\\"},{\\\"paramId\\\":6977,\\\"valueId\\\":\\\"1080626\\\"},{\\\"paramId\\\":6651,\\\"valueId\\\":\\\"511434\\\"}]\",\"productId\":\"1429029620453966849\",\"services\":\"[{\\\"serviceId\\\":\\\"40\\\"}]\"}";
        Object parse = JSON.parse(a);
        Map<String, Object> map = (Map<String, Object>) JSON.parse(a);
        System.out.println(parse);
        System.out.println(parse instanceof JSONObject);
    }
}
