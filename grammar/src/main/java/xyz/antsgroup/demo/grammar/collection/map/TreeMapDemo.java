package xyz.antsgroup.demo.grammar.collection.map;

import xyz.antsgroup.demo.grammar.collection.set.TreeSetDemo;

import java.util.*;

/**
 * TreeMap 红黑树实现的 map.
 * 基本操作和 TreeSet 类似.默认是对键进行排序,如果根据值排序见下.
 *
 * @see TreeSetDemo
 * @author ants_ypc
 * @version 1.0 4/30/16
 */
public class TreeMapDemo {
    public static void main(String[] args) {

        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("key" + i, i);
        }

        NavigableMap<String, Integer> desMap = map.descendingMap();
        System.out.println("descending map...");
        for (Map.Entry<String,Integer> entry : desMap.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

        System.out.println("normal order...");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

        /**
         * 如果需要根据 key 进行排序!
         * 有下列情况可能需要这种处理:
         * 读取一个文本,统计每个单词出现的次数,输出出现次数最多的20个单词和次数;
         * 交通管理中,统计马路实施车辆,输出车辆最多的马路和车数;
         */
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < 15; i++) {
            map1.put("key" + i, (int)(i * Math.random()*10));
        }
        SortedSet<Map.Entry<String,Integer>> sortedSet = new TreeSet<Map.Entry<String,Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int res = o1.getValue().compareTo(o2.getValue());
                return res != 0 ? res : o1.getKey().compareTo(o2.getKey());
            }
        });
        sortedSet.addAll(map1.entrySet());

        System.out.println("unsorted...");
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
        System.out.println("sorted...");
        for (Map.Entry<String, Integer> entry : sortedSet) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

    }
}
