package com.zhangyi.se.com.zhangyi.se;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/7 10:48
 */

import java.util.ArrayList;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;
import com.sun.tools.javadoc.Main;

/**
 * 类说明：打印类及其字段、方法的注释<br>
 * 使用javadoc实现<br>
 * 需要在工程中加载jdk中的包$JAVA_HOME/lib/tools.jar
 */
public class Doclet {

    /**
     * 测试
     */
    public static void main(String[] args) {
        //java源文件的路径
        ArrayList<String> sources = new ArrayList<>();
        sources.add("/D:/code/IdeaCode/MyStudy/javaSE/src/main/java/com/zhangyi/entry/User.java");
        //打印
        println(sources);
    }

    /**
     * 打印类及其字段、方法的注释
     *
     * @param sources java源文件路径
     */
    public static void println(ArrayList<String> sources) {
        ArrayList<String> list = new ArrayList<>();
        list.add("-private");
        list.add("-doclet");
        list.add(Doclet.class.getName());
        list.addAll(sources);
        Main.execute(list.toArray(new String[list.size()]));

        StringBuilder buffer = new StringBuilder();
        ClassDoc[] classes = Doclet.root.classes();
        for (ClassDoc classDoc : classes) {
            buffer.append(classDoc.name()).append('\n');
            buffer.append('\t').append(classDoc.commentText()).append('\n');
            buffer.append('\t').append("字段").append('\n');
            FieldDoc[] fields = classDoc.fields();
            for (FieldDoc field : fields) {
                buffer.append('\t').append('\t').append(field.name()).append('\n');
                buffer.append('\t').append('\t').append('\t').append(field.commentText()).append('\n');
            }
            buffer.append('\t').append("方法").append('\n');
            MethodDoc[] methods = classDoc.methods();
            for (MethodDoc method : methods) {
                buffer.append('\t').append('\t').append(method.name()).append('\n');
                buffer.append('\t').append('\t').append('\t').append(method.commentText()).append('\n');
            }
        }
        System.out.println(buffer);
    }

    /**
     * 文档根节点
     */
    private static RootDoc root;

    /**
     * javadoc调用入口
     *
     * @param root
     * @return
     */
    public static boolean start(RootDoc root) {
        Doclet.root = root;
        return true;
    }
}
