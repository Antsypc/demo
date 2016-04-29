package xyz.antsgroup.demo.grammar.collection.list;

import java.util.*;

/**
 * 当元素**增删**操作多时采用LinkedList,当需要随机访问时采用ArrayList,LinkedList可以当做队列或栈使用.
 * 把 LinkedList 当队列,栈使用时不要添加 null 元素,因为他是根据 null 判断队列是否为空的.
 */

public class LinkedListDemo {
    public static void main(String[] args) {

        /**
         * 构造方法
         */
        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> list0 = new LinkedList<>(new LinkedHashSet<>()); // 用另外一个 Collection 类初始化,直接拷贝元素实现,内部实际执行 addAll 方法

        /**
         * 基本的增删改查,这一部分的操作与 ArrayList 一毛一样. @see xyz.antsgroup.demo.grammar.collection.list.ArrayListDemo
         * 后面介绍当把 LinkedList 当做队列使用时的增删操作.(LinkedList 实现了 Deque 接口,双端队列)
         */
        // append
        list.add("Amy");    list.addAll(new LinkedList<String>() {{add("Erica");}});
        // insert
        list.add(0, "Carl");list.addAll(1,new LinkedList<String>() {{add("Erica");}});

        // 改
        list.set(0, "Young");   // 返回原来的值

        // get
        String tmp = list.get(0);

        // remove : 可以根据值,位置,全删
        list.remove(0);
        list.remove("a");
        list.removeAll(new ArrayList<String>() {{
            add("b");
            add("c");
        }});
        list.clear();

        list.add("d");
        list.add("s");
        list.add("h");
        list0.add("ddf");
        list0.add("ssd");

        /**
         * 遍历
         * 不要用索引遍历,内部链表实现所以很慢,每次都要从第一个开始找.
         */
        // for-each 本质是 Iterator,效率OK,不要用 for(int i=;i<;i++) 一类的方法遍历
        for (String s : list)
            System.out.println(s);

        // Iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String snow = iterator.next();
            //iterator.remove();  // 删除的是 next() 调用前经过的那个元素,指针始终存在两个元素中间.比如此时实际删除的是snow
        }

        // ListIterator : Iterator 只能向后遍历,这个既可以向前也可以向后遍历,并且可以进行增删改查操作
        // merge the words from b into a
        // 体会 ListIterator 能对 List 遍历的同时进行***增删改查***
        ListIterator<String> aIter = list.listIterator();
        Iterator<String> bIter = list0.iterator();
        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(list);

        // remove every second word from b
        bIter = list0.iterator();
        while (bIter.hasNext()) {
            bIter.next(); // skip one element
            if (bIter.hasNext()) {
                bIter.next(); // skip next element
                bIter.remove(); // remove that element
            }
        }
        System.out.println(list0);

        // 倒序 Iterator
        Iterator<String> desIterator = list.descendingIterator();


        /**
         * 把 LinkedList 当做队列使用的例子
         * 下面有很对元素操作的方法,总结一下比较好的使用方式(都是 Deque 有的方法):
         * 1. 向首尾添加元素: addFirst,addLast (offerFirst,offerLast)
         * 2. 获取首尾元素(没有则返回 null): peekFirst,peekLast.  有异常的是getFirst,getLast.
         * 3. 获取首尾元素并删除: pollFirst,pollLast.
         *
         * 把 LinkedList 当队列,栈使用时不要添加 null 元素,因为他是根据 null 判断队列是否为空的.
         *
         */
        // 向头部加
        list.addFirst("head");
        list.offerFirst("offer");   // 本质是 addFirst
        list.push("push");          // 本质是 addFirst

        // 向尾部加
        list.add("d");
        list.offer("d");            // 本质是 add
        list.addLast("d");          // 和 add 没区别
        list.offerLast("d");        // 和 add 没区别

        // 获取头部
        list.getFirst();            // 没有则抛出异常
        list.element();             // 本质是 getFirst
        list.peek();                // 没有则返回 null,和 peekFirst 一毛一样
        list.peekFirst();           // 没有则返回 null

        // 获取尾部
        list.getLast();             // 没有则抛出异常
        list.peekLast();            // 没有则返回 null

        // 获取头部并删除
        String head = list.poll();          // 和 pollFirst 一样
               head = list.pollFirst();     // 没有则返回 null
               head = list.remove();        // 与 removeFirst 一样
               head = list.removeFirst();   // 没有元素则抛出异常

        // 获取尾部并删除
        String tail = list.pollLast();      // 没有则返回 null
               tail = list.removeLast();    // 没有会抛出异常

    }
}
