package xyz.antsgroup.example.grammar.reflection;


import java.util.*;
import java.lang.reflect.*;

/**
 * 分析一个类所有的构造方法,方法和域.
 *
 * 预备知识:
 * Class 这个类是用来描述一个类的属性的.
 * 获取 Class 对象的两种方式:
 * 1. Class cl = Class.forName("java.util.Date");
 * 2. Class cl = date.getClass();
 * 获取 Class 对象当前的类名:
 * cl.getName();
 * 实例化一个 Class 代表的对象:
 * cl.newInstance();
 *
 * 获取构造方法信息:
 * Constructor[] constructors = cl.getDeclaredConstructors();   // 得到该 Class 的所有构造方法
 * c.getName(); // 获取每一个 Constructor 的名字
 * Modifier.toString(cl.getModifiers());    // 获取方法的修饰符
 * Class[] paramTypes = c.getParameterTypes();  // 获取构造方法的参数数组
 * paramTypes[j].getName();     // 获取该参数的名字
 *
 * 获取方法的信息:
 * Method[] methods = cl.getDeclaredMethods();  // 获取该 Class 的方法数组
 * m.getReturnType().getName(); // 获取每个方法返回类型的名字
 * m.getName(); // 获取方法名
 * 剩下的和上面一样
 *
 * 获取域的信息:
 * Field[] fields = cl.getDeclaredFields(); // 获取所有的域
 * 其他方法与上面一样:类型,名字
 *
 *
 * 设置一对像某域的值:
 * Field f = cl.getDeclaredField("name");
 * Object v = f.get(people);    // v 是people对象name的值
 * 如果name域是 private 的,那么此处get是有异常的.方法如下:
 * f.setAccessible(true);   // 解除 f 域的安全检查控制,使其可以任意访问
 * 把某类所有的域都设置为可任意访问:
 * AccessibleObject.setAccessible(fieldArray, true);
 */

public class ReflectionTest {
    public static void main(String[] args) {
        // read class name from command line args or user input
        String name;
        if (args.length > 0) name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        try {
            // print class name and superclass name (if != Object)
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (supercl != null && supercl != Object.class) System.out.print(" extends "
                    + supercl.getName());

            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Prints all constructors of a class
     *
     * @param cl a class
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            // print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all methods of a class
     *
     * @param cl a class
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("   ");
            // print modifiers, return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            // print parameter types
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all fields of a class
     *
     * @param cl a class
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}