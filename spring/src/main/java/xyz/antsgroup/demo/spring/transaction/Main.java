package xyz.antsgroup.demo.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.antsgroup.demo.spring.transaction.service.ChooseCourseService;

/**
 * Spring transaction 示例
 *
 * Created by Ants Young on 2016/7/16.
 */
public class Main {

    /*
    Spring 事务
    默认对 Runtime Exception 进行回滚,配置 rollbackFor 和 notRollbackFor 可以修改回滚等级.
    事务控制在 TransactionDefinition 中定义,主要包括事务传播,事务隔离级别,事务过期时间和事务读写特性.

    ## 事务隔离
    是直接对应数据库的事务隔离界别的,与 java.sql.Connection 定义一致.
    ISOLATION_DEFAULT          使用底层数据库默认的隔离等级.
    ISOLATION_READ_UNCOMMITTED 可能导致产生脏读,不可重复读和幻读
    ISOLATION_READ_COMMITTED   可能导致产生不可重复读和幻读
    ISOLATION_REPEATABLE_READ  可能导致幻读
    ISOLATION_SERIALIZABLE     能避免脏读,不可重复读和幻读

    - 脏读: A读了B修改还未提交的数据,所以B的数据是脏的.
          指当一个事务正在访问数据,并且对数据进行了修改,而这种修改还没有提交到数据库中,这时,
          另外一个事务也访问这个数据,然后使用了这个数据.因为这个数据是还没有提交的数据, 那么另外一
          个事务读到的这个数据是脏数据,依据脏数据所做的操作可能是不正确的.
    - 不可重复读: A读了数据,B这时改了,A再读发现两次数据不一样.
          指在一个事务内,多次读同一数据.在这个事务还没有结束时,另外一个事务也访问该同一数据.
          那么,在第一个事务中的两次读数据之间,由于第二个事务的修改,那么第一个事务两次读到的数据
          可能是不一样的.这样就发生了在一个事务内两次读到的数据是不一样的,因此称为是不可重复读.
    - 幻读: 这个和 non-repeatable reads 相似,也是同一个事务中多次读不一致的问题.
          但是 non-repeatable reads 的不一致是因为他所要取的数据集被改变了,但是 phantom reads
          所要读的数据的不一致却不是他所要读的数据集改变,而是他的条件数据集改变.比如第一次根据条件
          查出有6条记录,后来相同条件却有8条,产生幻读.

    可能各级别需要采取的策略
    - 脏读: 修改时,其他事务不可读
    - 不可重复读: 修改时需要行级锁,其他事务不可读不可写
    - 幻读: 修改时需要表级锁



    ## 事务传播
    即多个事务方法相互调用时,事务如何在方法间传播.假设在 a() 中调用 b(),下面是 b() 的事务传播配置.
    PROPAGATION_REQUIRED       如果 a 配置了事务, b 使用 a 配置的事务;否则使用自己的事务配置.
    PROPAGATION_SUPPORTS       如果 a 配置了事务就使用 a 的事务,否则自己也不在事务环境执行.
    PROPAGATION_MANDATORY      强制使用 a 的事务,如果 a 没有事务则抛出异常.

    PROPAGATION_REQUIRES_NEW   如果 a 有事务,把 a 的事务挂起,转而使用自己配置的事务.
    PROPAGATION_NOT_SUPPORTED  就算 a 有事务,也不把自己放在事务中执行.
    PROPAGATION_NEVER          强制要求 a 中没有事务,如果有事务则抛出异常.

    PROPAGATION_NESTED         如果 a 有事务,b 使用单独的事务,并且 b 可以有多个回滚点,回滚不对外部 a 造成影响.

     */


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-tx.xml");
        ChooseCourseService service = (ChooseCourseService) context.getBean("chooseCourseService");
        if (service.chooseCourse("0121310880439", 1)) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }

    }
}
