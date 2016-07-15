package xyz.antsgroup.demo.spring.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.antsgroup.demo.spring.aop.Target2;

/**
 * 使用 @AspectJ 注解配置 AOP
 * Created by Ants Young on 2016/7/15.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-demo-aop-annotation.xml");
        Target2 target = (Target2) context.getBean("target01");
        target.say("YOUNG");
    }
}
