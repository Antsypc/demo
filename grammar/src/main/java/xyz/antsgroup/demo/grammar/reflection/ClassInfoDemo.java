package xyz.antsgroup.demo.grammar.reflection;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

/**
 * Created by Ants Young on 2016/7/19.
 */
public class ClassInfoDemo {


    /*
    输出
    /D:/programfiles/IDEA_workspace/demo/grammar/target/classes/
    /D:/programfiles/IDEA_workspace/demo/grammar/target/classes/
    /D:/programfiles/IDEA_workspace/demo/grammar/target/classes/
    /D:/programfiles/IDEA_workspace/demo/grammar/target/classes/xyz/antsgroup/demo/grammar/reflection/
     */
    public static void main(String[] args) {

        /*
        获取当前 classpath 的绝对 URI
         */
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        System.out.println(ClassLoader.getSystemResource("").getPath());
        System.out.println(ClassInfoDemo.class.getResource("/").getPath());

        /*
        获取该类的绝对路径
         */
        System.out.println(ClassInfoDemo.class.getResource("").getPath());
    }
}
