package xyz.antsgroup.demo.grammar.string;

/**
 * @author ants_ypc
 * @version 1.0 3/9/16
 */
public class MyString {

    /**
     * 四种String对象比较方法:equals,compareTo,==,hashCode.
     */
    public void equalsTest() {
        String s1 = "abcd";
        String s2 = "cdsf";

        // boolean equals(Object o) 逐一比较字母是否相等
        if (s1.equals(s2)) System.out.println("equals");

        // int compareTo(String s) 按字典序比较大小,返回第一个不等的字符的差,如果长度不等返回长度差.
        System.out.println("compareTo:" + s1.compareTo(s2));

        // == 操作符实际比较的是对象在内存中的地址
        if(s1 == s2) System.out.println("s1 == s2");

        // hash 值的计算方式 h = 31 * h + val[i];
        System.out.println("hashcode:" + s1.hashCode());

    }

    public static void main(String[] args) {
        new MyString().equalsTest();
        // 输出结果:
        // compareTo:-2
        // hashcode:2987074
    }
}
