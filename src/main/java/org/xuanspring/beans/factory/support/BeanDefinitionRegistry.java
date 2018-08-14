package org.xuanspring.beans.factory.support;

import org.xuanspring.beans.BeanDefinition;

/**
 * @author Leo xuan
 * @date 2018/8/14
 */
public interface BeanDefinitionRegistry {
    BeanDefinition getBeanDefinition(String beanID);
    void registerBeanDefinition(String beanID, BeanDefinition bd);
}
