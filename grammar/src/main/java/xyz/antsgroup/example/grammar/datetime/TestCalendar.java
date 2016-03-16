package xyz.antsgroup.example.grammar.datetime;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 * 与其他语言环境敏感类一样,Calendar 提供了一个类方法 getInstance,以获得此类型的一个通用的对象.Calendar 的 getInstance 方法返回一个 Calendar 对象,其日历字段已由当前日期和时间初始化.
 * 一个Calendar的实例是系统时间的抽象表示,从Calendar的实例可以知道年月日星期月份时区等信息.Calendar类中有一个静态方法get(int x),通过这个方法可以获取到相关实例的一些值(年月日星期月份等)信息.参数x是一个产量值,在Calendar中有定义.
 *
 * Calendar中些陷阱,很容易掉下去：
 * Calendar的星期是从周日开始的,常量值为0.
 * Calendar的月份是从一月开始的,常量值为0.
 * Calendar的每个月的第一天值为1.
 */
public class TestCalendar {

    public void testCalendar() {
        //创建Calendar的方式
        Calendar now1 = Calendar.getInstance();
        Calendar now2 = new GregorianCalendar();
        Calendar now3 = new GregorianCalendar(2007, 10, 30);
        Calendar now4 = new GregorianCalendar(2007, 10, 30, 15, 55);      //陷阱:Calendar的月份是0~11
        Calendar now5 = new GregorianCalendar(2007, 10, 30, 15, 55, 44);
        Calendar now6 = new GregorianCalendar(Locale.US);
        Calendar now7 = new GregorianCalendar(TimeZone.getTimeZone("GMT-8:00"));

        //通过日期和毫秒数设置Calendar
        now2.setTime(new Date());
        System.out.println(now2);

        now2.setTimeInMillis(new Date().getTime());
        System.out.println(now2);


        //定义日期的中文输出格式,并输出日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 E", Locale.CHINA);
        System.out.println("获取日期中文格式化化输出：" + df.format(now5.getTime()));
        System.out.println();

        System.out.println("--------通过Calendar获取日期中年月日等相关信息--------");
        System.out.println("获取年：" + now5.get(Calendar.YEAR));
        System.out.println("获取月(月份是从0开始的)：" + now5.get(Calendar.MONTH));
        System.out.println("获取日：" + now5.get(Calendar.DAY_OF_MONTH));
        System.out.println("获取时：" + now5.get(Calendar.HOUR));
        System.out.println("获取分：" + now5.get(Calendar.MINUTE));
        System.out.println("获取秒：" + now5.get(Calendar.SECOND));
        System.out.println("获取上午,下午：" + now5.get(Calendar.AM_PM));
        System.out.println("获取星期数值(星期是从周日开始的)：" + now5.get(Calendar.DAY_OF_WEEK));
        System.out.println();

        System.out.println("---------通用星期中文化转换---------");
        String dayOfWeek[] = {"", "日", "一", "二", "三", "四", "五", "六"};
        System.out.println("now5对象的星期是:" + dayOfWeek[now5.get(Calendar.DAY_OF_WEEK)]);
        System.out.println();

        System.out.println("---------通用月份中文化转换---------");
        String months[] = {"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
        System.out.println("now5对象的月份是: " + months[now5.get(Calendar.MONTH)]);

        // 日期的加减运算
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2016, 5, 1);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(df.format(gregorianCalendar.getTime()));

    }

    public static void main(String args[]) {
        TestCalendar testCalendar = new TestCalendar();
        testCalendar.testCalendar();

    }
}