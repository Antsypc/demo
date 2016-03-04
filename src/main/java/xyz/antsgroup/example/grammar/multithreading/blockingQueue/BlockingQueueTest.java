package xyz.antsgroup.example.grammar.multithreading.blockingQueue;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * 使用阻塞队列完成并发搜索某目录下文件中的关键字.
 * 使用 锁和条件 机制,是Java并发程序的底层构建,实际编程最好使用更高层次的结构.
 * java.util.concurrent.BlockingQueue 内部实现了同步.
 *
 * 关于队列元素存取的操作方法:
 * 1. 如果队列是用来做线程管理(如生产者消费者中的队列通道),使用put,take方法.当队列满或者空,该线程将会被阻塞等待.
 * 2. 无异常的存取方法:offer,poll.当队列满或空时,返回false,null.
 * 3. 有异常的存取方法:add,remove.(不推荐)
 * 4. 只是用来获取头元素:element空则有异常,peek空则是null.
 * 注意:poll和peek是通过判断null来判断队列是否为空,所以通过这种方式存取元素就不要存null.
 */
public class BlockingQueueTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory (e.g. /usr/local/jdk1.6.0/src): ");
        String directory = in.nextLine();
        System.out.print("Enter keyword (e.g. volatile): ");
        String keyword = in.nextLine();

        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;

        // 常用两个实现了BlockingQueue接口的类ArrayBlockingQueue,LinkedBlockingQueue.
        BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

        FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(directory));
        new Thread(enumerator).start();     // 把directory目录下所有的文件放入queue中,SearchTask都从queue中读文件.
        for (int i = 1; i <= SEARCH_THREADS; i++)
            new Thread(new SearchTask(queue, keyword)).start();
    }
}

/**
 * This task enumerates all files in a directory and its subdirectories.
 */
class FileEnumerationTask implements Runnable
{
    public static File DUMMY = new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;

    /**
     * Constructs a FileEnumerationTask.
     * @param queue the blocking queue to which the enumerated files are added
     * @param startingDirectory the directory in which to start the enumeration
     */
    public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory)
    {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    public void run()
    {
        try
        {
            enumerate(startingDirectory);
            queue.put(DUMMY);
        }
        catch (InterruptedException e)
        {
        }
    }

    /**
     * Recursively enumerates all files in a given directory and its subdirectories.
     * @param directory the directory in which to start
     */
    public void enumerate(File directory) throws InterruptedException
    {
        File[] files = directory.listFiles();
        for (File file : files)
        {
            if (file.isDirectory()) enumerate(file);
            else queue.put(file);
        }
    }
}

/**
 * This task searches files for a given keyword.
 */
class SearchTask implements Runnable
{
    private BlockingQueue<File> queue;
    private String keyword;

    /**
     * Constructs a SearchTask.
     * @param queue the queue from which to take files
     * @param keyword the keyword to look for
     */
    public SearchTask(BlockingQueue<File> queue, String keyword)
    {
        this.queue = queue;
        this.keyword = keyword;
    }

    public void run()
    {
        try
        {
            boolean done = false;
            while (!done)
            {
                File file = queue.take();
                if (file == FileEnumerationTask.DUMMY)
                {
                    queue.put(file);
                    done = true;
                }
                else search(file);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
        }
    }

    /**
     * Searches a file for a given keyword and prints all matching lines.
     * @param file the file to search
     */
    public void search(File file) throws IOException
    {
        try (Scanner in = new Scanner(file))
        {
            int lineNumber = 0;
            while (in.hasNextLine())
            {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword))
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
            }
        }
    }
}