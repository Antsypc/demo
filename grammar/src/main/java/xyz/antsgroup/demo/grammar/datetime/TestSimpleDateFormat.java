package xyz.antsgroup.demo.grammar.datetime;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestSimpleDateFormat {

    public void testDateFormat() throws ParseException {
        //创建日期
        Date date = new Date();

        //创建指定的日期格式
        DateFormat df1 = DateFormat.getInstance();
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE");
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);     //产生一个指定国家指定长度的日期格式,长度不同,显示的日期完整性也不同
        DateFormat df4 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE", Locale.CHINA);    // h小写表示12小时制,大小表示24小时制
        DateFormat df5 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EEEEEE", Locale.US);
        DateFormat df6 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df7 = new SimpleDateFormat("yyyy年MM月dd日");
        DateFormat df8 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");                      // 大小写字母是保留字符,如果需要用需要用单引号

        //将日期按照格式进行输出
        System.out.println("-------将日期按照不同格式进行输出------");
        System.out.println("按照Java默认的日期格式,默认的区域                      : " + df1.format(date));
        System.out.println("按照指定格式 yyyy-MM-dd HH:mm:ss EE ,系统默认区域      :" + df2.format(date));
        System.out.println("按照日期的FULL模式,区域设置为中文                      : " + df3.format(date));
        System.out.println("按照指定格式 yyyy年MM月dd日 hh时mm分ss秒 EE ,区域为中文 : " + df4.format(date));
        System.out.println("按照指定格式 yyyy-MM-dd hh:mm:ss EE ,区域为美国        : " + df5.format(date));
        System.out.println("按照指定格式 yyyy-MM-dd ,系统默认区域                  : " + df6.format(date));
        System.out.println("按照指定格式 yyyy年MM月dd日 ,系统默认区域                  : " + df7.format(date));

        //将符合该格式的字符串转换为日期,若格式不相配,则会出错
        Date date1 = df1.parse("07-11-30 下午2:32");
        Date date2 = df2.parse("2007-11-30 02:51:07 星期五");
        Date date3 = df3.parse("2007年11月30日 星期五");
        Date date4 = df4.parse("2007年11月30日 02时51分18秒 星期五");
        Date date5 = df5.parse("2007-11-30 02:51:18 Friday");
        Date date6 = df6.parse("2007-11-30");

        System.out.println("-------输出将字符串转换为日期的结果------");
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date4);
        System.out.println(date5);
        System.out.println(date6);
    }

    public static void main(String args[]) throws ParseException {
        TestSimpleDateFormat test = new TestSimpleDateFormat();
        test.testDateFormat();

    }
//    -------将日期按照不同格式进行输出------
//    按照Java默认的日期格式,默认的区域                      : 3/16/16 8:19 PM
//    按照指定格式 yyyy-MM-dd hh:mm:ss EE ,系统默认区域      :2016-03-16 08:19:08 Wed
//    按照日期的FULL模式,区域设置为中文                      : 2016年3月16日 星期三
//    按照指定格式 yyyy年MM月dd日 hh时mm分ss秒 EE ,区域为中文 : 2016年03月16日 08时19分08秒 星期三
//    按照指定格式 yyyy-MM-dd hh:mm:ss EE ,区域为美国        : 2016-03-16 08:19:08 Wednesday
//    按照指定格式 yyyy-MM-dd ,系统默认区域                  : 2016-03-16
//    按照指定格式 yyyy年MM月dd日 ,系统默认区域                  : 2016年03月16日
//    Exception in thread "main" java.text.ParseException: Unparseable date: "07-11-30 下午2:32"
//    at java.text.DateFormat.parse(DateFormat.java:366)
//    at TestSimpleDateFormat.testDateFormat(TestSimpleDateFormat.java:40)
//    at TestSimpleDateFormat.main(TestSimpleDateFormat.java:12)
//    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//    at java.lang.reflect.Method.invoke(Method.java:497)
//    at com.intellij.rt.execution.application.AppMain.main(AppMain.java:140)

}