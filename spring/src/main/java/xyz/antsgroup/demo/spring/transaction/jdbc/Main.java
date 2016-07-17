package xyz.antsgroup.demo.spring.transaction.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用 Spring JDBC 示例
 *
 * 有时使用 Hibernate 或者 Mybatis 上层 ORM 框架不能做一些自定义操作,
 * 使用 Spring JDBC 可以直接操作底层方法.
 *
 * Created by Ants Young on 2016/7/17.
 */
public class Main {

    /*
    Spring 数据连接
    利用 JdbcTemplate 和 DataSourceUtils 获取连接和操作底层数据等操作.

    ## Spring JDBC 数据连接泄露问题
    - 使用 `jdbcTemplate.getDataSource().getConnection()` 是从数据源直接获取的 Connection,
      如果不主动释放会导致连接泄露.
    - 使用 `DataSourceUtils.getConnection(jdbcTemplate.getDataSource())` 是从当前**方法所在
      事务上下文**获取的连接,方法执行完毕事务提交自然会释放连接,所以不用主动去释放连接也不会导致连接泄露.
      如果获取连接的当前方法没有事务,那么连接泄露还是会发生,必须在 finally 中执行
      `DataSourceUtils.releaseConnection(conn, jdbcTemplate.getDataSource())`


     */

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-tx.xml");
        CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
//        int re = categoryDao.addCategory("书籍", 0);
//        System.out.println("re:" + re);
        System.out.println(categoryDao.getCategoryById(1));
    }
}
