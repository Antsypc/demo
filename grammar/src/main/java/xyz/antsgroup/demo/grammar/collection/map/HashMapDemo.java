package xyz.antsgroup.demo.grammar.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap 通过对键 hash,数组实现.
 *
 * @author ants_ypc
 * @version 1.0 4/30/16
 */
public class HashMapDemo {
    public static void main(String[] args) {
        /**
         * 构造方法
         */
        HashMap<String, Integer> map = new HashMap<>();
        // 内部数组实现,能大致估算容量能减少不必要的数组拷贝.
        // load factor 默认为 .75f, 当一个 map 填满了75%的bucket时,
        // 将会创建原来HashMap大小的两倍的bucket数组,将原来的对象放入新的bucket数组中.
        // 这个过程叫作rehashing,因为它调用hash方法找到新的bucket位置.
        HashMap<String, Integer> map1 = new HashMap<>(40, .9f);

        /**
         * 增删改查
         */
        // 增
        map.put("first", 1);
        map.put("second", 1);
        map.put("third", 1);

        // 删
        Integer value = map.remove("first");
        boolean success = map.remove("fi", 2);    // 只有当存在这样的元素时才删除

        // 改
        map.put("second", 2);       // 覆盖原始值
        map.replace("third", 3);    // 返回原始值
        map.replace("third", 1, 4); // 如果存在 ("third",1) 则替换 为 ("third",4)

        // 查
        map.get("third");


        /**
         * 遍历
         */
        // 方法一:同时需要键值对时 Set<Map.Entry<K,V>>	entrySet()
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer v = entry.getValue();
            System.out.println("key=" + key + ", value=" + v);
        }
        // 方法二:单独需要键值对时 Set<K>	keySet(), Collection<V>	values()
        for (String key : map.keySet()) {
            System.out.println("key=" + key);
        }
        for (Integer e : map.values()) {
            System.out.println("value=" + e);
        }

    }
}
