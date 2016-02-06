

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import xyz.antsgroup.example.hibernate.entity.ConsumablesEntity;


/**
 * Created by ants_ypc on 1/30/16.
 */
public class Main {
    private static final SessionFactory sessionFactory;

    static {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public static Session getSession() throws HibernateException {
        // openSession & getCurrentSession
        // getCurrentSession 使用完后会自动关闭,每次使用同一个session对象.需要在cfg.xml中配置hibernate.current_session_context_class
        return sessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();   // 相当于jdbc的connection对象,session与connection是多对一的关系
        session.beginTransaction();
        session.save(new ConsumablesEntity("矿泉水", 26, 100000, "ml"));   // hibernate默认就是不自动提交事务的.如果需要自动提交使用session.doWork()

        // 查询
        // get 立刻执行语句查询.对象不存在是返回null
        // load 先返回一个代理对象,当真正使用对象的非主属性才去查询,对象不存在时抛出异常
        ConsumablesEntity consumablesEntity = session.get(ConsumablesEntity.class, "硝酸25%");
        System.out.println(consumablesEntity.getConsumablesId());
        session.getTransaction().commit();
        session.close();
    }
}
