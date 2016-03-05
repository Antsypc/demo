package xyz.antsgroup.example.grammar.multithreading.forkJoin;

import java.util.concurrent.*;

/**
 * This program demonstrates the fork-join framework.
 *
 *
 */
public class ForkJoinTest
{
    public static void main(String[] args)
    {
        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) numbers[i] = Math.random();
        Counter counter = new Counter(numbers, 0, numbers.length,
                new Filter()
                {
                    public boolean accept(double x) { return x > 0.5; }
                });
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);   // 开始执行counter中的compute方法
        System.out.println(counter.join()); // 获取counter执行的返回结果
    }
}

interface Filter
{
    boolean accept(double t);
}

class Counter extends RecursiveTask<Integer>
{
    public static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private Filter filter;

    public Counter(double[] values, int from, int to, Filter filter)
    {
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    // RecursiveTask<> 是继承自 ForkJoinTask<>, 必须要实现抽象方法 T compute()
    protected Integer compute()
    {
        if (to - from < THRESHOLD)
        {
            int count = 0;
            for (int i = from; i < to; i++)
            {
                if (filter.accept(values[i])) count++;
            }
            return count;
        }
        else
        {
            int mid = (from + to) / 2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, mid, to, filter);
            invokeAll(first, second);   // 阻塞等待两个都完成
            return first.join() + second.join();
        }
    }
}