package xyz.antsgroup.example.grammar.multithreading.threadPool;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * 使用Java线程池管理多线程任务.
 *
 * 1. 创建线程池
 * ExecutorService pool = Executors.newCachedThreadPool();  // 创建带缓存线程池,在必要时创建线程,线程空闲60s后自动销毁
 * ExecutorService pool = Executors.newFixedThreadPool(10); // 创建指定线程数目的线程池
 *
 * 2. 创建可执行多线程类的对象实例
 * 该对象实现了Runnable接口或者实现了Callable接口.当然包括Thread类的子类(他也是实现了Runnable接口的)
 *
 * 3. 将多线程对象提交给线程池,并让线程池执行
 * Future<Integer> result = pool.submit(counter);   // 此处counter实现了Callable接口
 * // 如果是Runnable接口的对象,pool.submit(counter)之后使用result.get()将得到null,
 * // 使用pool.submit(counter, T)后,使用result.get()得到T对象
 *
 * 4. 关闭线程池
 * pool.shutdown();
 * // 执行该方法后,不再接受新的submit操作,线程池中线程任务完成就立即销毁该线程.
 * // 如果使用 pool.shutdownNow() 将会取消所有任务并中断所有运行的线程
 */
public class ThreadPoolTest
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
        String directory = in.nextLine();
        System.out.print("Enter keyword (e.g. volatile): ");
        String keyword = in.nextLine();

        ExecutorService pool = Executors.newCachedThreadPool();

        MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
        Future<Integer> result = pool.submit(counter);

        try
        {
            System.out.println(result.get() + " matching files.");
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
        }
        pool.shutdown();

        int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println("largest pool size=" + largestPoolSize);
    }
}

/**
 * This task counts the files in a directory and its subdirectories that contain a given keyword.
 */
class MatchCounter implements Callable<Integer>
{
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    /**
     * Constructs a MatchCounter.
     * @param directory the directory in which to start the search
     * @param keyword the keyword to look for
     * @param pool the thread pool for submitting subtasks
     */
    public MatchCounter(File directory, String keyword, ExecutorService pool)
    {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    public Integer call()
    {
        count = 0;
        try
        {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

            for (File file : files)
                if (file.isDirectory())
                {
                    MatchCounter counter = new MatchCounter(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }
                else
                {
                    if (search(file)) count++;
                }

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