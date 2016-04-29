package xyz.antsgroup.demo.grammar.collection.queue;

import java.util.*;

/**
 * 优先队列 PriorityQueue 相当与堆结构.
 * 1. 始终返回最小的元素,如果需要始终返回最大的元素,在构造是传入 Comparator 接口的对象.
 * 2. 由于需要比较大小,不允许传入 null.
 *
 * 基本队列是Queue接口,LinkedList也是实现了这个接口的,优先级队列PriorityQueue.
 * 双端队列接口Deque,实现了该接口的类有LinkedList,ArrayDeque...
 * 由此看出,需要使用队列时,LinkedList 是很好的选择
 *
 */
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        /**
         * 构造方法
         */
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
        // 自定义大小比较规则
        @SuppressWarnings("unchecked")
        PriorityQueue<String> pq0 = new PriorityQueue<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o2).compareTo((String)o1);
            }
        });
        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9)); // G. Hopper
        pq.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10)); // A. Lovelace
        pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3)); // J. von Neumann
        pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22)); // K. Zuse

        /**
         * 增删改查
         * 由于继承 AbstractQueue, 只能向尾部加,从首部获取或删除
         */
        // 添加
        pq0.add("abc");     // 本质是 offer
        pq0.offer("dfs");   // 不允许空元素的添加
        // 获取
        String a = pq0.peek();  // 没有则返回 null
        // 获取并删除
        String b = pq0.poll();  // 没有则返回 null



        /**
         * 遍历 : 不保证顺序
         */
        System.out.println("Iterating over elements...");
        for (GregorianCalendar date : pq)
            System.out.println(date.get(Calendar.YEAR));

        // 优先队列 PriorityQueue 始终返回最小的元素
        System.out.println("Removing elements...");
        while (!pq.isEmpty())
            System.out.println(pq.remove().get(Calendar.YEAR));

    }
}