package com.zhangyi.se.com.zhangyi.se;

/**
 * @author ZhangYi zhangyi04@zhuanzhuan.com
 * @date 2021/9/7 10:12
 */

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;

public class JavaDocReader {
    private static RootDoc root;

    // 一个简单Doclet,收到 RootDoc对象保存起来供后续使用
    // 参见参考资料6
    public static class Doclet {

        public Doclet() {
        }

        public static boolean start(RootDoc root) {
            JavaDocReader.root = root;
            return true;
        }
    }

    // 显示DocRoot中的基本信息
    public static void show() {
        ClassDoc[] classes = root.classes();
        for (int i = 0; i < classes.length; ++i) {
            System.out.println(classes[i]);
            System.out.println(classes[i].commentText());
            for (MethodDoc method : classes[i].methods()) {
                System.out.printf("\t%s\n", method.commentText());
            }
        }
    }

    public static RootDoc getRoot() {
        return root;
    }

    public JavaDocReader() {

    }

    public static void main(final String... args) throws Exception {
        // 调用com.sun.tools.javadoc.Main执行javadoc,参见 参考资料3
        // javadoc的调用参数，参见 参考资料1
        // -doclet 指定自己的docLet类名
        // -classpath 参数指定 源码文件及依赖库的class位置，不提供也可以执行，但无法获取到完整的注释信息(比如annotation)
        // -encoding 指定源码文件的编码格式
        com.sun.tools.javadoc.Main.execute(new String[]{"-doclet",
                Doclet.class.getName(),
                "-docletpath",
                Doclet.class.getResource("/").getPath(),
                "-encoding", "utf-8",
                "D:/code/IdeaCode/MyStudy/javaSE/src/main/java/com/zhangyi/entry/User.java"});
//                "-classpath",
//                "D:/j/facelog/facelog-main/target/classes;D:/j/facelog/db/target/classes;D:/j/facelog/db/sql2java/lib/swift-annotations-0.14.2.jar",
//                "J:/facelog/facelog-main/src/main/java/net/gdface/facelog/FaceLogDefinition.java"});
        show();
    }
}
