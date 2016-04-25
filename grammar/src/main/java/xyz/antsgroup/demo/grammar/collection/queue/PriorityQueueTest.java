package xyz.antsgroup.demo.grammar.collection.queue;

import java.util.*;

/**
 * 优先队列 PriorityQueue 相当与堆结构.
 * 始终返回最小的元素,如果需要始终返回最大的元素,在构造是传入 Comparator 接口的方法.
 *
 * 基本队列是Queue接口,LinkedList也是实现了这个接口的,优先级队列PriorityQueue.
 * 双端队列接口Deque,实现了该接口的类有LinkedList,ArrayDeque...
 * 由此看出,需要使用队列时,LinkedList 是很好的选择
 *
 * 队列!元素存取的操作方法:
 * 1. 如果队列是用来做线程管理(如生产者消费者中的队列通道),使用put,take方法.当队列满或者空,该线程将会被阻塞等待.
 * 2. 无异常的存取方法:offer,poll.当队列满或空时,返回false,null.
 * 3. 有异常的存取方法:add,remove.(不推荐)
 * 4. 只是用来获取头元素:element空则有异常,peek空则是null.
 * 注意:poll和peek是通过判断null来判断队列是否为空,所以通过这种方式存取元素就不要存null.
 */
public class PriorityQueueTest
{
    public static void main(String[] args)
    {
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9)); // G. Hopper
        pq.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10)); // A. Lovelace
        pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3)); // J. von Neumann
        pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22)); // K. Zuse

        // 遍历不保证顺序
        System.out.println("Iterating over elements...");
        for (GregorianCalendar date : pq)
            System.out.println(date.get(Calendar.YEAR));

        // 优先队列 PriorityQueue 始终返回最小的元素
        System.out.println("Removing elements...");
        while (!pq.isEmpty())
            System.out.println(pq.remove().get(Calendar.YEAR));
    }
}