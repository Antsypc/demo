package xyz.antsgroup.example.grammar.collection.map;

import java.util.*;

/**
 * Map接口两大实现类:HashMap,TreeMap.如果顺序不重要,HashMap更快.
 * 如果对同一个键使用两次put方法,后一次将覆盖前一次的值.
 * Map 对象可以获取三个视图:键Set<K> KeySet();值Collection<K> values();键值对Set<Map.Entry<K, V>> entrySet();
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

        // replace an entry

        staff.put("456-62-5527", new Employee("Francesca Miller"));

        // look up a value

        System.out.println(staff.get("157-62-7935"));

        // iterate through all entries

        for (Map.Entry<String, Employee> entry : staff.entrySet())
        {
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value);
        }
    }
}
