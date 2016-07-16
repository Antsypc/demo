package xyz.antsgroup.demo.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.antsgroup.demo.spring.transaction.service.ChooseCourseService;

/**
 * Created by Ants Young on 2016/7/16.
 */
public class Main {



    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-tx.xml");
        ChooseCourseService service = (ChooseCourseService) context.getBean("chooseCourseService");
        if (service.chooseCourse("0121310880435", 1)) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }

    }
}
