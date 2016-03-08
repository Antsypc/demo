package xyz.antsgroup.example.grammar.multithreading.synchronizedCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Java 集合类中 Vector 和 HashTable 是线程安全的,其他不是.
 * 但是现在不建议使用这两个类而是通过Collection.synchronizedXxx(),或者使用java.util.concurrent包中的类.
 *
 * @author ants_ypc
 * @version 1.0 3/4/16
 */
public class SynchronizedCollectionTest {

    public static void main(String[] args) {
        // 使用 Collection.synchronizedXxx() 可以保证集合类变成线程安全的.
        // 但是,这只代表着使用集合本身的方法时是原子同步操作.如下.
        List<String> list = new ArrayList<>();
        Collections.synchronizedList(list);
        list.add("a");  // 是线程同步安全的.

        if (!list.isEmpty())    // 这两步的结合操作不能保证线程安全,因为不能估计isEmpty操作和get操作之间list是否有改变
            list.get(0);        // 必须在这整块代码外加锁

        // 上两句可以改写为
        synchronized (list) {
            if (!list.isEmpty())
                list.get(0);
        }



        // 使用java.util.concurrent包中的类.
        // 这些类都是通过复杂算法,实现了高效的集合操作,可以让多个线程安全的同时操作一个集合对象.如:
        // ConcurrentHashMap,ConcurrentSkipListMap,ConcurrentSkipListSet,ConcurrentLinkedQueue

    }
}
