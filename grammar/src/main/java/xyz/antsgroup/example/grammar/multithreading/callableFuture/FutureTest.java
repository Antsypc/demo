package xyz.antsgroup.example.grammar.multithreading.callableFuture;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * 实现了Callable接口的类结合实现了Future接口的类,可以获取多线程运行的结果.
 *
 * 1. class Counter implements Callable<T>, T是线程允许返回值的类型.该方法必须实现 public T call()方法.该方法类似于Runnable接口的run方法
 * 2. FutureTask<T> task = new FutureTask<>(counter); 将实现了Callable接口的对象传入Future
 * 3. task.get(); 如果线程没有运行完毕,该线程会被阻塞,当线程运行完毕就返回T类型的值.
 *
 */
public class FutureTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
        String directory = in.nextLine();
        System.out.print("Enter keyword (e.g. volatile): ");
        String keyword = in.nextLine();

        MatchCounter counter = new MatchCounter(new File(directory), keyword);
        FutureTask<Integer> task = new FutureTask<>(counter);
        Thread t = new Thread(task);
        t.start();
        try
        {
            System.out.println(task.get() + " matching files.");
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
        }
    }
}

/**
 * This task counts the files in a directory and its subdirectories that contain a given keyword.
 */
class MatchCounter implements Callable<Integer>
{
    private File directory;
    private String keyword;
    private int count;

    /**
     * Constructs a MatchCounter.
     * @param directory the directory in which to start the search
     * @param keyword the keyword to look for
     */
    public MatchCounter(File directory, String keyword)
    {
        this.directory = directory;
        this.keyword = keyword;
    }

    public Integer call()
    {
        count = 0;
        try
        {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();  // 亮点在这里,体会如何最终能获取文件总数的

            // results 相当与保存了每个线程计算的结果

            // 先让多个计算线程计算,把结果保存在Future<>对象中
            for (File file : files)
                if (file.isDirectory())
                {
                    MatchCounter counter = new MatchCounter(file, keyword); // 亮点
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                }
                else
                {
                    if (search(file)) count++;
                }

            // 开始获取每个线程的结果,再相加
            for (Future<Integer> result : results)
                try
                {
                    count += result.get();
                }
                catch (ExecutionException e)
                {
                    e.printStackTrace();
                }
        }
        catch (InterruptedException e)
        {
        }
        return count;
    }

    /**
     * Searches a file for a given keyword.
     * @param file the file to search
     * @return true if the keyword is contained in the file
     */
    public boolean search(File file)
    {
        try
        {
            try (Scanner in = new Scanner(file))
            {
                boolean found = false;
                while (!found && in.hasNextLine())
                {
                    String line = in.nextLine();
                    if (line.contains(keyword)) found = true;
                }
                return found;
            }
        }
        catch (IOException e)
        {
            return false;
        }
    }
}