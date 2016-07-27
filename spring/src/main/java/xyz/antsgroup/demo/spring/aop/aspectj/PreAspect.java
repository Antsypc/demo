package xyz.antsgroup.demo.spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 使用注解配置前置增强
 * Created by Ants Young on 2016/7/15.
 */
@Aspect
@Component
public class PreAspect {

    /**
     * 注解 @Before 表示前置增强
     * 在目标类的 say 方法上织入增强,say 方法可以带任意的参数和返回值
     */
    @Before("execution(* say(..))")
    public void beforeSay() {
        System.out.println("before advice by @AspectJ.");
    }

}
