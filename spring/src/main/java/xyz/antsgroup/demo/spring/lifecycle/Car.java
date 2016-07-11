package xyz.antsgroup.demo.spring.lifecycle;

import org.springframework.beans.factory.*;

/**
 * 探讨 Bean 生命周期.
 * 以下接口都是管理 Bean 生命周期的,在对应Test类有相关调用.
 *
 * Created by Ants Young on 2016/7/11.
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("Car() constructor.");
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("invoke BeanNameAware.setBeanName().");
        this.beanName = beanName;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println("invoke BeanFactoryAware.setBeanFactory().");
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("invoke InitializingBean.afterPropertiesSet()");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("invoke DisposableBean.destroy().");
    }

    public void myInit() {
        System.out.println("在 <bean> 中配置 init-method,指定调用该方法.");
    }

    public void myDestroy() {
        System.out.println("在 <bean> 中配置 destroy-method,指定调用该方法.");
    }

    public void introduce() {
        System.out.println("Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}');
    }

    /*
    Car() constructor.
    invoke BeanNameAware.setBeanName().
    invoke BeanFactoryAware.setBeanFactory().
    invoke InitializingBean.afterPropertiesSet()
    在 <bean> 中配置 init-method,指定调用该方法.
    Car{brand='ferrari', color='null', maxSpeed=200, beanFactory=org.springframework.beans.factory.support.DefaultListableBeanFactory@8909f18: defining beans [myCar]; root of factory hierarchy, beanName='myCar'}
    xyz.antsgroup.demo.spring.lifecycle.Car@1460a8c0
    invoke DisposableBean.destroy().
    在 <bean> 中配置 destroy-method,指定调用该方法.
    */
}
