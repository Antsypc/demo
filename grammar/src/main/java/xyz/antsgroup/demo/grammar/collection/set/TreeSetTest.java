package xyz.antsgroup.demo.grammar.collection.set;

import java.util.*;

/**
 * 将元素存入TreeSet中,并按照Item的描述排序
 *
 * 加入TreeSet中的元素必须实现 Comparable<E> 接口,这是由于TreeSet加入元素时自动排序,需要进行比较
 * 当元素顺序不重要时,不提倡使用TreeSet,使用HashSet
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<>(
                new Comparator<Item>() {
                    public int compare(Item a, Item b) {
                        String descrA = a.getDescription();
                        String descrB = b.getDescription();
                        return descrA.compareTo(descrB);
                    }
                });

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}