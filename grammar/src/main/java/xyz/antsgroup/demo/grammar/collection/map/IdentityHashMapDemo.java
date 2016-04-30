package xyz.antsgroup.demo.grammar.collection.map;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * IdentityHashMap 只是不允许键值同时相等,允许同键不同值的元素,判断是否相等是具体到内存区块.
 *
 * @author ants_ypc
 * @version 1.0 4/30/16
 */
public class IdentityHashMapDemo {
    public static void main(String[] args) {
        IdentityHashMap<String, Integer> map = new IdentityHashMap<>();
        // 只保存了一个
        map.put("a",1);
        map.put("a",1);
        // 只保存了一个,后者
        map.put("dsf", 23);
        map.put("dsf", 2345);
        // 保存了两个
        map.put(new String("go"), 2);
        map.put(new String("go"), 2);
        // 保存了两个
        map.put(new String("java"), 234);
        map.put(new String("java"), 342545);
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }
}
