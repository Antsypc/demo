package xyz.antsgroup.demo.spring.lifecycle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Ants Young on 2016/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-lifecycle.xml"})
public class CarTest {

    ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring-lifecycle.xml"});
    }

    @Test
    public void testGetBean() {
        Car car = (Car) applicationContext.getBean("myCar");
//        car.introduce();
        System.out.println(car);
    }
}
