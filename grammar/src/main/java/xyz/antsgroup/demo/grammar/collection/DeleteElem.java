package xyz.antsgroup.demo.grammar.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 删除List中符合条件的元素
 * @author antsyoung@qq.com
 * @version 1.0 2017-03-22
 */
public class DeleteElem {

    /*
    1. 使用for-i循环删除元素时，只要索引不出错，能成功删除
    2. 使用for-each循环删除肯定会出错，除非删除后就退出
    3. 建议使用iterator删除特定元素
     */

    /**
     * 当元素是基本类型时，使用for-i循环删除不会报错，如下。但是使用for-each循环会报错。
     */
    public static void deleteListElemForEach(ArrayList<Integer> list) {
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                list.remove(list.get(i));
                System.out.println(list);
            }
        }
        System.out.println(list);
    }

    /**
     * 使用for-i正常删除，使用for-each不能正常删除（注释部分）
     */
    public static void deleteListObjectElemForEach(ArrayList<Student> list) {
        System.out.println(list);
//        for (Student i : list) {
//            if (i.age < 0) {
//                list.remove(i);
//                System.out.println(list);
//                // break;
//            }
//        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).age < 0) {
                list.remove(list.get(i));
                System.out.println(list);
            }
        }
        System.out.println(list);
    }

    /**
     * 使用Iterator删除不会出错
     */
    public static void iteratorRemove(ArrayList<Student> list) {
        System.out.println(list);
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.age < 0) {
                it.remove();
            }
            System.out.println(list);
        }
        System.out.println(list);
    }

    static class Student {
        int age;

        public Student(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "{age=" + age + '}';
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> list1 = new ArrayList<Student>(){{
            add(new Student(1));
            add(new Student(-1));
            add(new Student(2));
            add(new Student(-2));
            add(new Student(3));
            add(new Student(-3));
        }};
//        deleteListObjectElemForEach(list1);

        iteratorRemove(list1);

//        ArrayList<Integer> list = new ArrayList<Integer>(){{
//            add(1);
//            add(-1);
//            add(2);
//            add(-2);
//            add(3);
//            add(-3);
//        }};
//        deleteListElemForEach(list);
    }
}
