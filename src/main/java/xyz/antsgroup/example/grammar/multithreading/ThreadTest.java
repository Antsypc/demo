package xyz.antsgroup.example.grammar.multithreading;

/**
 * 1. 继承Thread类,并实现run()方法
 * 2. 实现Runnable接口,并实现run()方法
 *
 * 对比:
 * 1. 最好使用实现Runnable接口方法.
 * 2. 如果需要使用Thread类其他的方法,就采用继承Thread类.
 * 3. 如果一个类已经是继承了某一个类,那么只能通过实现Runnable接口,因为java是单继承.
 *
 * @author ants_ypc
 * @version 1.0 3/3/16
 */
public class ThreadTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("this is " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadTest()).start();
        }
    }
}
