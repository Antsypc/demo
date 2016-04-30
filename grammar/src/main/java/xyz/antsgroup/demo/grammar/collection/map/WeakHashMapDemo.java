package xyz.antsgroup.demo.grammar.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * WeakHashMap 如果存入的对象没有外界的引用或者为null,将会自动回收.
 *
 * http://www.jb51.net/article/36948.htm
 *
 * @author ants_ypc
 * @version 1.0 4/30/16
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        String a = new String("a");
        String b = new String("b");
        Map<String,String> weakmap = new WeakHashMap<>();
        Map<String,String> map = new HashMap<>();

        map.put(a, "aaa");
        map.put(b, "bbb");

        weakmap.put(a, "aaa");
        weakmap.put(b, "bbb");

        map.remove(a);

        a=null;
        b=null;

        System.gc();
        Iterator i = map.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry en = (Map.Entry)i.next();
            System.out.println("map:"+en.getKey()+":"+en.getValue());
        }

        Iterator j = weakmap.entrySet().iterator();
        while (j.hasNext()) {
            Map.Entry en = (Map.Entry)j.next();
            System.out.println("weakmap:"+en.getKey()+":"+en.getValue());

        }
    }

}
