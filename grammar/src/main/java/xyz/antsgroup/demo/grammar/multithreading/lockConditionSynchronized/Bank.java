package xyz.antsgroup.demo.grammar.multithreading.lockConditionSynchronized;

import java.util.concurrent.locks.*;

/**
 * A bank with a number of bank accounts that uses locks for serializing access.
 *
 * Lock 对象      : lock.lock() 与 lock.unlock() 间的代码只允许一个线程执行.
 *                  ReentrantLock 可重入锁,能保证同一线程递归调用该部分代码,也不冲突.
 *
 * Condition 对象 : 一线程在执行时条件不足,需要暂停,等待其他线程执行后使条件满足.
 *                  condition 对象生成方法: Condition con = lock.newCondition();
 *                  需要等待使用:con.await(); 每当该条件有改变时就使用con.signalAll();
 *
 * synchronized 关键字相当于结合使用了上两个.只需要在需要锁定的方法名前添加synchronized关键字即可.
 *              等效方法使用见下文transfer2. 深层次原理:java每个类都有一个自带的内部锁和内部条件.
 *
 * 比较分析:
 * 1. synchronized 方法只能有一个锁, 有时一个锁可能不够.且不能设定获取锁的超时条件.
 * 2. 最好既不使用Lock/Condition 也不使用 synchronized,而使用 java.util.concurrent 中提供的机制.
 * 3. 如果需要且足以满足需求, synchronized 是很好的选择.
 *
 * --------------------------------------------
 * 其他:
 * 1. synchronized 对一段程序需要同步(实现客户端锁定),具体实现是:
 * private Object lock = new Object();  // 定义一个变量专门用来进行绑定
 *
 * synchronized(lock) {
 *      //需要同步的代码
 * }
 *
 * 2. volatile
 * 声明为volatile的域,能保证同步读写.但是,它并不保证原子性.
 * 正确的使用方式是:要么get要么set,不能同时读写,如 done = !done.
 * 详见解释 http://www.cnblogs.com/Mainz/p/3556430.html
 *
 * 3. final
 * 显然声明为final的变量,能保证每次访问的都是同一个变量.但是如果是List一类的变量,并不能保证对象内数据的同步读写.
 *
 * 4. Lock 的 tryLock() 方法
 * 如果成功获得锁则返回true,失败返回false,这样可以根据不同情况做不同的事,而不用阻塞.
 *
 * 5. 如果对一个类的数据更多的是读,少量的写,那么使用 ReentrantReadWriteLock 类进行加锁更有效:
 * private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
 * private Lock readLock = rwl.readLock();
 * private Lock writeLock = rwl.writeLock();
 *
 * 对所有读的方法:
 * public double get() {
 *     readLock.lock();
 *     try{}
 *     finally{readLock.unlock();}
 * }
 * 同理,对所有写的方法:
 * public double set() {
 *     writeLock.lock();
 *     try{}
 *     finally{writeLock.unlock();}
 * }
 *
 */

public class Bank
{
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    /**
     * Constructs the bank.
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public Bank(int n, double initialBalance)
    {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++)
            accounts[i] = initialBalance;
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * Transfers money from one account to another.
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(int from, int to, double amount) throws InterruptedException
    {
        bankLock.lock();    // 阻止多个线程同时执行该部分代码
        try
        {
            // 如果条件需要,就阻止获得锁的线程继续执行,进行该条件的等待集
            // 当有其他线程调用signalAll()方法时,所有被await()方法阻塞的线程被唤醒.
            // 某一个重新获得锁的线程,从该方法返回,继续执行while循环
            while (accounts[from] < amount)
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        }
        finally
        {
            bankLock.unlock();
        }
    }

    /**
     * Gets the sum of all account balances.
     * @return the total balance
     */
    public double getTotalBalance()
    {
        bankLock.lock();
        try
        {
            double sum = 0;

            for (double a : accounts)
                sum += a;

            return sum;
        }
        finally
        {
            bankLock.unlock();
        }
    }

    /**
     * Gets the number of accounts in the bank.
     * @return the number of accounts
     */
    public int size()
    {
        return accounts.length;
    }

    /**
     * synchronized 相当于在方法的开始结尾对内部锁调用了 lock() 和 unlock().
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     * @throws InterruptedException
     */
    public synchronized void transfer2(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount)
            wait();     // 相当于 condition.await()
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();    // 相当于 condition.signalAll()
    }
}