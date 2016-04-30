package xyz.antsgroup.demo.grammar.collection.set;

import java.util.*;

/**
 * HashSet 拥有集合的性质,内部实际上是用 HashMap 存储, 添加的元素作为 map 的键,值是一个固定值.
 *
 * 1. 只能添加或删除已知元素,不能修改其中的元素,需要删除再添加.
 * 2. 不能通过序号去遍历,只能使用 iterator().
 *
 *
 * 从控制台读取 wordsForHashSetTest.txt
 * $ java HashSetDemo < wordsForHashSetTest.txt
 */
public class HashSetDemo
{
    /**
     * 从控制台读取 wordsForHashSetTest.txt
     * $ java HashSetDemo < wordsForHashSetTest.txt
     * @param args 控制台参数
     */
    public static void main(String[] args)
    {
        Set<String> words = new HashSet<>(); // HashSet implements Set
        long totalTime = 0;

        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;
        }

        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }
}