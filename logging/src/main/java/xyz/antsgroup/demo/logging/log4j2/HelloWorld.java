package xyz.antsgroup.demo.logging.log4j2;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.message.StructuredDataMessage;

/**
 * Created by ants_ypc on 1/27/16.
 */
public class HelloWorld {
    /**
     * 日志级别,从低到高.一般默认级别为error,可在配置文件(支持xml,json,properties,yaml)中配置. log只打印日志级别比他高的
     * trace: 是追踪,就是程序推进一下
     * debug
     * info: 输出一下你感兴趣的或者重要的信息,这个用的最多
     * warn: 有些信息不是错误信息,但是也要给程序员的一些提示,类似于eclipse中代码的验证不是有error 和warn
     * error: 错误信息,用的也比较多
     * fatal: 重大错误,这种级别你可以直接停止程序了,但这只是一个程度的问题
     */

    // LogManager.getLogger()中传入String参数只是设置的该logger的名字,
    // 如果下次getLogger使用的还是相同的名字,则返回该对象.用名字来唯一标识logger对象
    // 如果不提供参数则默认logger名字是当前类的 fully qualified class name,如xyz.antsgroup.example.logging.log4j2.HelloWorld
    private static final Logger logger = LogManager.getLogger("HelloWorld");

    public static void main(String[] args) {
        logger.entry();                 //trace级别的信息，单独列出来是希望你在某个方法或者程序逻辑开始的时候调用，和logger.trace("entry")基本一个意思
        logger.trace("我是trace信息");   //info级别的信息
        logger.debug("我是debug信息");
        logger.log(Level.DEBUG, "我是debug信息,Level.DEBUG");   //这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
        logger.info("我是info信息");
        logger.info("格式化传入数据 {}{}", "参数1", "参数2");
        logger.warn("我是warn信息");
        logger.error("我是error信息");
        logger.fatal("我是fatal信息");
        logger.exit();                  //和entry()对应的结束方法，和logger.trace("exit");一个意思

        logger.entry();
        try {
            int a = 1 / 0;
        } catch (Exception ex) {
            logger.catching(ex);
        }
        logger.exit();


        /*进阶内容*/
        // Markers,还不是很清楚作用
        String tableName = "table_name";
        MyApp myApp = new MyApp();
        myApp.doQuery(tableName);

        // ThreadContext 例如在servlet filter 中如下操作
        // 并在配置文件的appender-patternlayout-pattern中加入%mdc
        // 每次logger输出是都会把ThreadContext中的信息输出如 %mdc 对应 {ipAddress=22.22.22.22, hostname=ypc-hostname}
//        HttpServletRequest req = (HttpServletRequest) request;
//        ThreadContext.put("ipAddress", req.getRemoteAddr());
//        ThreadContext.put("hostname", "ypc-hostname");
//        // 该filter结束后执行
//        ThreadContext.clearAll();

        // 输出结构化数据,使用StructuredDataMessage & EventLogger
        StructuredDataMessage msg = new StructuredDataMessage("confirm", null, "transfer"); // id,msg,type
        msg.put("toAccount", "toAccount-value");
        msg.put("fromAccount", "fromAccount-value");
        msg.put("amount", "amount-value");
        // 输出:transfer [confirm amount="amount-value" fromAccount="fromAccount-value" toAccount="toAccount-value"]
        EventLogger.logEvent(msg);

    }
}
