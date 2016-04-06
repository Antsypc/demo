package xyz.antsgroup.demo.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ants_ypc
 * @version 1.0 4/5/16
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂,使用 id=development 的配置
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();

        // UserEntityMapper 中 namespace + 对应 select 标签的 id.
        String statement = "UserEntity.getUserEntity";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        UserEntity user = session.selectOne(statement, 1);
        System.out.println(user);
    }
}
