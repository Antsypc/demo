package xyz.antsgroup.example.grammar.collection.map;

import java.util.*;

/**
 * Map接口两大实现类:HashMap,TreeMap.如果顺序不重要,HashMap更快.
 * 如果对同一个键使用两次put方法,后一次将覆盖前一次的值.
 * Map<K, V> 其中K,V不能是原始类型必须是对象.如 int 必须改为 Integer.
 * Map 对象可以获取三个视图:键Set<K> KeySet();值Collection<K> values();键值对Set<Map.Entry<K, V>> entrySet();
 *
 * 首先简单说一下他们之间的区别：
 * HashMap: 最常用的Map,它根据键的HashCode 值存储数据,根据键可以直接获取它的值，具有很快的访问速度。HashMap最多只允许一条记录的键为Null(多条会覆盖);允许多条记录的值为 Null。非同步的。
 * TreeMap: 能够把它保存的记录根据键(key)排序,默认是按升序排序，也可以指定排序的比较器，当用Iterator 遍历TreeMap时，得到的记录是排过序的。TreeMap不允许key的值为null。非同步的。
 * Hashtable: 与 HashMap类似,不同的是:key和value的值均不允许为null;它支持线程的同步，即任一时刻只有一个线程能写Hashtable,因此也导致了Hashtale在写入时会比较慢。
 * LinkedHashMap: 保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的.在遍历的时候会比HashMap慢。key和value均允许为空，非同步的。
 */
public class MapTest
{
    public static void main(String[] args)
    {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

        // print all entries
        System.out.println(staff);

        // remove an entry
        staff.remove("567-24-2546");

        // replace an entry, 再次插入相同键的,就相当于是替换
        staff.put("456-62-5527", new Employee("Francesca Miller"));

        // look up a value
        System.out.println(staff.get("157-62-7935"));

        /////////////////////////////////
        // 遍历 Map 对象
        // 方法一:同时需要键值对时
        for (Map.Entry<String, Employee> entry : staff.entrySet()) {
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value);
        }
        // 方法二:单独需要键值对时
        for (String key : staff.keySet()) {
            System.out.println("key=" + key);
        }
        for (Employee e : staff.values()) {
            System.out.println("value=" + e);
        }

        ////////////////////////////////
        // TreeMap 对象插入时就自动排序,遍历输出的值就已经是排序了
        TreeMap<Integer, Integer> intMap = new TreeMap<>();
        intMap.put(2, 3);
        intMap.put(9, 4);
        intMap.put(5, 4);
        intMap.put(1, 4);
        // 按顺序获取
        for (Map.Entry<Integer, Integer> entry : intMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value);
        }
        // 获取倒序
        Map<Integer, Integer> deMap = intMap.descendingMap();   // 此处Map类型后的泛型类型不能省
        for (Map.Entry<Integer, Integer> entry : deMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value);
        }

    }
}
