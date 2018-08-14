package org.xuanspring.beans.factory.config;

/**
 * @author Leo xuan
 * @date 2018/8/14
 */
public interface SingletonBeanFactory {

    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);


}
