package xyz.antsgroup.example.grammar.datetime;

import java.util.Date;

public class TestDate {

    /**
     * 获取系统当前时间
     * System.currentTimeMillis()返回系统当前时间,结果为1970年1月1日0时0分0秒开始,到程序执行取得系统时间为止所经过的毫秒数
     * 1秒＝1000毫秒
     */
    public void getSystemCurrentTime() {
        System.out.println("----获取系统当前时间----");
        System.out.println("系统当前时间 = " + System.currentTimeMillis());
    }

    /**
     * 通过Date类获取当前日期和当前时间
     * date.toString()把日期转换为dow mon dd hh:mm:ss zzz yyyy
     */
    public void getCurrentDate() {
        System.out.println("----获取系统当前日期----");
        //创建并初始化一个日期(初始值为当前日期)
        Date date = new Date();
        System.out.println("现在的日期是 = " + date.toString());
        System.out.println("自1970年1月1日0时0分0秒开始至今所经历的毫秒数 = " + date.getTime());
    }

    public static void main(String args[]) {
        TestDate nowDate = new TestDate();
        nowDate.getSystemCurrentTime();
        nowDate.getCurrentDate();
    }

}