package xyz.antsgroup.demo.grammar.collection.map;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap 操作上与 HashMap 无异,但是LinkedHashMap 保留了插入顺序,实现了 LRU 算法:最近使用的放在最后.
 * 即在 HashMap 的 Node 节点实现上还有上一元素和下一个元素的索引.
 *
 * @author ants_ypc
 * @version 1.0 4/30/16
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // 第三个参数是 accessOrder :true for access-order, false for insertion-order, 默认为 false
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16,.75f,true);

        for (int i = 0; i < 5; i++) {
            map.put("key" + i, i);
        }
        map.get("key3");
        map.replace("key4", 44);

        // 由于 accessOrder 为 true, 输出时 3 最后输出, LRU(Least Recently Used)算法
        for (Integer v : map.values()) {
            System.out.println(v);
        }
    }
}
