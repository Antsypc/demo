Java日期时间使用总结
============
## Java中的日期概述

在Java中,操作日期主要涉及到一下几个类：
* `java.util.Date`精确到毫秒.推荐使用`Calendar`类实现日期和时间字段之间转换,使用`DateFormat`类来格式化和分析日期字符串.`Date`中的把日期解释为年,月,日,小时,分钟和秒值的方法已废弃.
* `java.text.DateFormat`(抽象类)DateFormat 是日期/时间格式化子类的抽象类,它以与语言无关的方式格式化并分析日期或时间.日期/时间格式化子类(如 SimpleDateFormat)允许进行格式化(也就是日期 -> 文本),分析(文本-> 日期)和标准化.将日期表示为 Date 对象,或者表示为从 GMT(格林尼治标准时间)1970 年,1 月 1 日 00:00:00 这一刻开始的毫秒数.
* `java.text.SimpleDateFormat`(DateFormat的直接子类)SimpleDateFormat 是一个以与语言环境相关的方式来格式化和分析日期的具体类.它允许进行格式化(日期 -> 文本),分析(文本 -> 日期)和规范化.SimpleDateFormat 使得可以选择任何用户定义的日期-时间格式的模式.但是,仍然建议通过 DateFormat 中的 getTimeInstance,getDateInstance 或 getDateTimeInstance 来新的创建日期-时间格式化程序.
* `java.util.Calendar`(抽象类)Calendar 类是一个抽象类,它为特定瞬间与一组诸如 YEAR,MONTH,DAY_OF_MONTH,HOUR 等 日历字段之间的转换提供了一些方法,并为操作日历字段(例如获得下星期的日期)提供了一些方法.瞬间可用毫秒值来表示,它是距历元(即格林威治标准时间 1970 年 1 月 1 日的 00:00:00.000,格里高利历)的偏移量.与其他语言环境敏感类一样,Calendar 提供了一个类方法 getInstance,以获得此类型的一个通用的对象.Calendar 的 getInstance 方法返回一个 Calendar 对象,其日历字段已由当前日期和时间初始化.
* `java.util.GregorianCalendar`(Calendar的直接子类)GregorianCalendar 是 Calendar 的一个具体子类,提供了世界上大多数国家使用的标准日历系统.GregorianCalendar 是一种混合日历,在单一间断性的支持下同时支持儒略历和格里高利历系统,在默认情况下,它对应格里高利日历创立时的格里高利历日期(某些国家是在 1582 年 10 月 15 日创立,在其他国家要晚一些).可由调用方通过调用 setGregorianChange() 来更改起始日期.

## java.util.Date的使用
类 `java.util.Date` 表示特定的瞬间,精确到毫秒.提供了很多的方法,但是很多已经过时,不推荐使用,下面仅仅列出没有过时的方法：
 
构造方法摘要

    Date()
              分配 Date 对象并用当前时间初始化此对象,以表示分配它的时间(精确到毫秒).
    Date(long date)
              分配 Date 对象并初始化此对象,以表示自从标准基准时间(称为“历元(epoch)”,即 1970 年 1 月 1 日 00:00:00 GMT)以来的指定毫秒数.

方法摘要

    boolean after(Date when)
             测试此日期是否在指定日期之后.
    
    boolean before(Date when)
             测试此日期是否在指定日期之前.
    
    Object clone()
             返回此对象的副本.
    
    int compareTo(Date anotherDate)
             比较两个日期的顺序.
    
    boolean equals(Object obj)
             比较两个日期的相等性.
    
    long getTime()
             返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数.
    
    int hashCode()
             返回此对象的哈希码值.
    
    void setTime(long time)
             设置此 Date 对象,以表示 1970 年 1 月 1 日 00:00:00 GMT 以后 time 毫秒的时间点.
    
    String toString()
             把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy 其中：
             dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat).
             mon 是月份 (Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec).
             dd 是一月中的某一天(01 至 31),显示为两位十进制数.
             hh 是一天中的小时(00 至 23),显示为两位十进制数.
             mm 是小时中的分钟(00 至 59),显示为两位十进制数.
             ss 是分钟中的秒数(00 至 61),显示为两位十进制数.
             zzz 是时区(并可以反映夏令时).标准时区缩写包括方法 parse 识别的时区缩写.如果不提供时区信息,则 zzz 为空,即根本不包括任何字符.
             yyyy 是年份,显示为 4 位十进制数.

## java.text.DateFormat抽象类的使用
DateFormat 提供了很多类方法,以获得基于默认或给定语言环境和多种格式化风格的默认日期/时间 Formatter.格式化风格包括 FULL,LONG,MEDIUM 和 SHORT.方法描述中提供了使用这些风格的更多细节和示例.
 
DateFormat 可帮助进行格式化并分析任何语言环境的日期.对于月,星期,甚至日历格式(阴历和阳历),其代码可完全与语言环境的约定无关.
 
要格式化一个当前语言环境下的日期,可使用某个静态工厂方法：

    myString = DateFormat.getDateInstance().format(myDate);

如果格式化多个日期,那么获得该格式并多次使用它是更为高效的做法,这样系统就不必多次获取有关环境语言和国家约定的信息了.

    DateFormat df = DateFormat.getDateInstance();
    for (int i = 0; i < myDate.length; ++i) {
     output.println(df.format(myDate[i]) + "; ");
    }
 
要格式化不同语言环境的日期,可在 getDateInstance() 的调用中指定它.

    DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
 
还可使用 DateFormat 进行分析.

    myDate = df.parse(myString);
 
使用 getDateInstance 来获得该国家的标准日期格式.另外还提供了一些其他静态工厂方法.使用 getTimeInstance 可获得该国家的时间格式.使用 getDateTimeInstance 可获得日期和时间格式.可以将不同选项传入这些工厂方法,以控制结果的长度(从 SHORT 到 MEDIUM 到 LONG 再到 FULL).确切的结果取决于语言环境,但是通常：
* SHORT 完全为数字,如 12.13.52 或 3:30pm
* MEDIUM 较长,如 Jan 12, 1952
* LONG 更长,如 January 12, 1952 或 3:30:32pm
* FULL 是完全指定,如 Tuesday, April 12, 1952 AD 或 3:30:42pm PST.

DateFormat 不是同步的.建议为每个线程创建独立的格式实例.如果多个线程同时访问一个格式,则它必须保持外部同步.
 
## java.text.SimpleDateFormat(DateFormat的直接子类)的使用
SimpleDateFormat 使得可以选择任何用户定义的日期-时间格式的模式.但是,仍然建议通过 DateFormat 中的 getTimeInstance,getDateInstance 或 getDateTimeInstance 来新的创建日期-时间格式化程序.每一个这样的类方法都能够返回一个以默认格式模式初始化的日期/时间格式化程序.可以根据需要使用 applyPattern 方法来修改格式模式.有关使用这些方法的更多信息,请参阅 DateFormat.
 
日期和时间模式
日期和时间格式由日期和时间模式 字符串指定.在日期和时间模式字符串中,未加引号的字母 'A' 到 'Z' 和 'a' 到 'z' 被解释为模式字母,用来表示日期或时间字符串元素.文本可以使用单引号 (') 引起来,以免进行解释."''" 表示单引号.所有其他字符均不解释；只是在格式化时将它们简单复制到输出字符串,或者在分析时与输入字符串进行匹配.

## java.util.Calendar(抽象类)
与其他语言环境敏感类一样,Calendar 提供了一个类方法 getInstance,以获得此类型的一个通用的对象.Calendar 的 getInstance 方法返回一个 Calendar 对象,其日历字段已由当前日期和时间初始化.
 
一个Calendar的实例是系统时间的抽象表示,从Calendar的实例可以知道年月日星期月份时区等信息.Calendar类中有一个静态方法get(int x),通过这个方法可以获取到相关实例的一些值(年月日星期月份等)信息.参数x是一个产量值,在Calendar中有定义.
 
Calendar中些陷阱,很容易掉下去：
* Calendar的星期是从周日开始的,常量值为0.
* Calendar的月份是从一月开始的,常量值为0.
* Calendar的每个月的第一天值为1.
 
## java.util.GregorianCalendar(Calendar的直接子类)
GregorianCalendar 是 Calendar 的一个具体子类,提供了世界上大多数国家使用的标准日历系统.结合Calendar抽象类使用.


## 总结
Java中日期的经常有一下五个方面：
* 创建日期
* 日期格式化显示
* 日期的转换(主要是和字符串之间的相互转换)
* 日期中年,月,日,时,分,秒,星期,月份等获取.
* 日期的大小比较,日期的加减.