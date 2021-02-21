package com.huatech.mall.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author like
 * @date 2021-02-19 1:20 下午
 * TransactionManagementConfigurationSelector给容器导入组件
 * 导入两个组件：
 *       AutoProxyRegistrar
 *       ProxyTransactionManagementConfiguration
 *
 * AutoProxyRegistrar给容器注册
 *   InfrastructureAdvisorAutoProxyCreator组件
 *   利用后置处理器机制在对象创建以后，包装对象，返回一个代理对象(增强器)，代理对象执行方法利用拦截器进行拦截
 *
 * ProxyTransactionManagementConfiguration 做了什么？
 *   1：给容器中注册事务增强器：BeanFactoryTransactionAttributeSourceAdvisor
 *       1)事务管理器要用事务注解的信息，AnnotationTransactionAttributeSource解析事务信息
 *       2)事务拦截器
 *          TransactionInterceptor：保存了事务属性信息，事务管理器
 *          他是一个MethodInterceptor
 *           在执行目标方法的时候
 *                执行拦截器链
 *                事务拦截器:
 *                    1:先获取事务相关的属性
 *                    2：在获取PlatformTransactionManager，如果事先没有添加指定任何TransactionManager
 *                    最终会从容器中按照类型获取一个在获取PlatformTransactionManager
 *                    3：执行目标方法
 *                      如果异常，获取事务管理器，利用事务管理器进行事务回滚这次操作
 *                      如果正常，获取事务管理器，利用事务管理器进行事务提交这次操作
 *
 *
 **/
@Configuration
@EnableTransactionManagement
public class MyTransactionManager {


}