package xyz.antsgroup.demo.grammar.collection.set;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet 继承自HashSet, 只不过使用是用链表实现, 内部使用 LinkedHashMapDemo 保存元素.
 *
 * 操作方式与 HashSet 无异.
 *
 * @see HashSetDemo
 * @author ants_ypc
 * @version 1.0 4/30/16
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
    }
}
