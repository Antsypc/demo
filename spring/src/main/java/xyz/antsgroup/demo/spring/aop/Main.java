package xyz.antsgroup.demo.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP 实例运行状态
 *
 * Created by Ants Young on 2016/7/14.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-demo-aop.xml");

        /*
        1. 如果 spring bean 配置使用 proxyTargetClass="true", 那么返回类型使用类名 Target 作为引用.
           如果没有 proxyTargetClass,而是使用 proxyInterfaces,则使用[其中一个](因为可以配置多个接口)接口作为引用
        2. Advice 接口的切面都是面向目标类的所有方法的,设置的横切代码对这个类所有的方法都适用.
         */
        ITarget target = (ITarget) context.getBean("targetProxy01");
        target.greetTo("YOUNG");
        try {
            target.serveTo("ANTS");
        } catch (Exception e) {
            System.out.println("catch exception");
        }

        /*
        使用 pointcut advisor 静态普通方法匹配切面
        1. 在代理对象 targetProxy02 和 targetProxy03 中设置的切面只对 say 方法有效,Target 中没有 say 方法,
           Target2 中有 say 方法,所以 target2 会被植入横切代码.

         */
        System.out.println("================StaticMethodMatcherPointcutAdvisor=====================");
        Target target1 = (Target) context.getBean("targetProxy02");
        target1.greetTo("GROUP-TARGET1");
        Target2 target2 = (Target2) context.getBean("staticMethodProxy");
        target2.say("GROUP-TARGET2");

        /*
        静态正则表达方法匹配切面
         */
        System.out.println("================RegexpMethodPointcutAdvisor===================");
        Target2 target3 = (Target2) context.getBean("staticRegexProxy");
        target3.say("GROUP-TARGET3");

        /*
        动态匹配切面
         */
        System.out.println("================DynamicMethodMatcherPointcut===================");
        Target2 target4 = (Target2) context.getBean("dynamicProxy01");
        target4.say("sss");
        target4.say("aaa");

        /*
        流程切面
         */
        System.out.println("================ControlFlowPointcut===================");
        Target2 target21 = (Target2) context.getBean("controlFlowPointProxy");
        Target2Delegate delegate = new Target2Delegate();
        delegate.setTarget2(target21);
        // 直接调用 Target2 的 say,serveTo 是不会被植入横切代码的
        target21.say("GROUP-TARGET-DELEGATE");
        target21.serveTo("GROUP-TARGET-DELEGATE");
        // 会被植入
        delegate.service("GROUP-TARGET-DELEGATE");

        // 引介增强 IntroductionInterceptor

    }
}
