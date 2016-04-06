package xyz.antsgroup.demo.grammar.innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * 1.内部类既可以访问自身的数据域,也可以访问创建他的对象的数据域.
 * 2.局部内部类:类的定义在一个方法中时.这样,只有该方法知道该类的存在.
 * 3.匿名内部类:见
 *
 * 探究1的实现:
 * 使用 javap -private className 观察编译器实际生成的代码
 * javap -private InnerClassTest.class
 * Compiled from "InnerClassTest.java"
 * public class InnerClassTest {
 * public InnerClassTest();
 * public static void main(java.lang.String[]);
 * }
 *
 * javap -private TalkingClock.class
 * Compiled from "InnerClassTest.java"
 * class TalkingClock {
 * private int interval;
 * private boolean beep;
 * public TalkingClock(int, boolean);
 * public void start();
 * static boolean access$000(TalkingClock);
 * }
 *
 * javap -private TalkingClock\$TimePrinter.class
 * Compiled from "InnerClassTest.java"
 * public class TalkingClock$TimePrinter implements java.awt.event.ActionListener {
 * final TalkingClock this$0;
 * public TalkingClock$TimePrinter(TalkingClock);
 * public void actionPerformed(java.awt.event.ActionEvent);
 * }
 *
 * TalkingClock是TimePrinter的外围类,编译器在外围类生成了一个静态方法access$000,在调用内部类是把自身传入.
 * 编译器给内部类生成了final外围类的引用,这样内部类就可以调用外围类的域了
 */
public class InnerClassTest
{
    public static void main(String[] args)
    {
        TalkingClock clock = new TalkingClock(1000, true);

//        在外部创建内部类对象的方法
//        TalkingClock.TimePrinter listener = clock.new TimePrinter();
//        Timer t = new Timer(1000, listener);
//        t.start();

        clock.start();

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);


    }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock
{
    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     * @param interval the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
     */
    public TalkingClock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    public void start()
    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }


    public class TimePrinter implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Date now = new Date();
            System.out.println("At the tone, the time is " + now);
            // 内部类既可以访问自身的数据域,也可以访问创建他的对象的数据域
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}