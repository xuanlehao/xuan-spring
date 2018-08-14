package org.xuanspring.beans.factory.config;

import org.xuanspring.beans.factory.BeanFactory;

/**
 * @author Leo xuan
 * @date 2018/8/14
 */
public interface ConfigurableBeanFactory extends BeanFactory{
    void setBeanClassLoader(ClassLoader beanClassLoader);
    ClassLoader getBeanClassLoader();
}
