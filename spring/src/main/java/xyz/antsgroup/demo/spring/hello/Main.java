package xyz.antsgroup.demo.spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ants_ypc on 10/11/15.
 */
public class Main {

    public static void main(String arg[]) {

        // 创建IOC容器对象
        // 使用BeanFactory（更底层）或者ApplicationContext创建IOC容器，主要是后者
        // 在web项目中可以通过web.xml配置如下
//        <listener>
//        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
//        </listener>
//        <servlet>
//        <servlet-name>context</servlet-name>
//        <servlet-class>org.springframework.web.context.ContextLoaderServlet</servlet-class>
//        </servlet>
        ApplicationContext acx = new ClassPathXmlApplicationContext("spring-config.xml");   // 在classpath中寻找该文件

        // 获取IOC中Bean实例
        // 创建HelloWorld对象，先后调用构造函数和set函数
        HelloWorld helloWorld1 = (HelloWorld) acx.getBean("hello1");
        HelloWorld helloWorld2 = (HelloWorld) acx.getBean("hello2");
        HelloWorld helloWorld3 = (HelloWorld) acx.getBean("hello3");
        HelloWorld helloWorld4 = (HelloWorld) acx.getBean("hello4");
        HelloWorld helloWorld5 = (HelloWorld) acx.getBean("hello5");
        // 调用需要对象的方法
        helloWorld1.hello();
        helloWorld2.hello();
        helloWorld3.hello();
        helloWorld4.hello();
        helloWorld5.hello();
    }
}
