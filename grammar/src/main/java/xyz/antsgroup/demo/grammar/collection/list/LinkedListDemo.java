package xyz.antsgroup.demo.grammar.collection.list;

import java.util.*;

/**
 * 当元素增删操作多时采用LinkedList,当需要随机访问时采用ArrayList,LinkedList可以当做队列或栈使用.
 * List如果访问第n个元素 list.get(n),每次都是从头开始读取选择.
 * 如果只需要一个迭代器读元素: list.iterator();
 * 如果需要一个迭代器对list进行插入,修改,向前遍历操作: list.listIterator();
 * <p>
 * 遍历实现Iterator接口的集合的两种方式:
 * iter = c.iterator();
 * while(iter.hasNext()) {
 * String element = iter.next();
 * do with element...
 * }
 * 更好的方式:
 * for(String element : c) {
 * do with element...
 * }
 * <p>
 * List的操作不是线程安全的,而Vector操作是线程安全是同步的.
 */

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // merge the words from b into a

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        // remove every second word from b

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next(); // skip one element
            if (bIter.hasNext()) {
                bIter.next(); // skip next element
                bIter.remove(); // remove that element
            }
        }

        System.out.println(b);

        // bulk operation: remove all words in b from a

        a.removeAll(b);

        System.out.println(a);
    }
}
