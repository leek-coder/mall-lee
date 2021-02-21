package com.huatech.mall.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author like
 * @date 2021-02-18 2:47 下午
 * @Import(AspectJAutoProxyRegistrar.class) ImportBeanDefinitionRegistrar
 * <p>
 * AspectJAnnotationAutoProxyCreator
 * AnnotationAwareAspectJAutoProxyCreator
 * ->AspectJAwareAdvisorAutoProxyCreator
 * ->AbstractAdvisorAutoProxyCreator
 * ->AbstractAutoProxyCreator
 * ->implements  SmartInstantiationAwareBeanPostProcessor & BeanFactoryAware
 * 关注后置处理器(在bean初始化前后做的事情),自动装配BeanFactory
 **/
@Aspect
public class MyAspectJ {

    @Pointcut("execution(public * com.huatech.mall.service.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
        String name = joinpoint.getSignature().getName();
        System.out.println("=========我是before=======");

    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void returning(Object result) {
        System.out.println("我是AfterReturning：" + result);
    }
}