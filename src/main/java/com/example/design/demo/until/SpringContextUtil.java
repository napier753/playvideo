/*
package com.example.design.demo.until;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

*/
/**
 *  springContextUtil
 * @author wangweiren 2018/8/22 10:27
 *//*

public class SpringContextUtil {
    private static ApplicationContext applicationContext;

    */
/**
     * 获取上下文
     * @return
     *//*

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    */
/**
     * 设置上下文
     * @param applicationContext
     *//*

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    */
/**
     * 通过名字获取上下文中的bean
     * @param name
     * @return
     *//*

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    */
/**
     * 通过类型获取上下文中的bean
     * @param requiredType
     * @return
     *//*

    public static Object getBean(Class<?> requiredType){
        return applicationContext.getBean(requiredType);
    }

    */
/**
     *  动态注入bean
     * @param requiredType 注入类
     * @param beanName bean名称
     * @return 注入实例
     *//*

    public static Object registerBean(Class<?> requiredType,String beanName){

        //将applicationContext转换为ConfigurableApplicationContext
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;

        //获取BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getAutowireCapableBeanFactory();

        //创建bean信息.
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(requiredType);

        //动态注册bean.
        defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());

        //获取动态注册的bean.
        return configurableApplicationContext.getBean(requiredType);
    }
}

*/
