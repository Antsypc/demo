package xyz.antsgroup.example.grammar.innerClass.anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * 由于构造器与类名相同,而匿名类没有类名,所以匿名类没有构造器.取而代之的是把超类的构造器传给他.
 *
 * 两种情况使用匿名内部类很好:
 * 1.该类只有此处使用;
 * 2.一个对象只使用一次:如添加多个元素的List对象:
 *   ArrayList<String> friends = new ArrayList<>();
 *   friends.add("Ha");
 *   friends.add("Sh");
 *   invite(friends);
 *   改写为:
 *   invite(new ArrayList<String>() {{add("Ha"); add("Sh");}});
 *   上面两层括号,第一层代表一个子类.第二层括号相当于对象构造块:对象构造的时候一次执行该类的static{},{}...区域的代码.
 */

public class AnonymousInnerClassTest
{
    public static void main(String[] args) {
        int outInt = 4;
        Bx bx = new Bx() {
            @Override
            public String get(final int outInt) { // 此处的final也可以不加
                return "get " + outInt + ",匿名内部类使用外部的参数需要使用final.";
            }
        };
        System.out.println(bx.get(4));

        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

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
    /**
     * Starts the clock.
     * @param interval the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
     */
    public void start(int interval, boolean beep)
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }
}

interface Bx {
    String get(int i);
}