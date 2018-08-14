package org.xuanspring.beans.factory.support;

import org.xuanspring.beans.BeanDefinition;
import org.xuanspring.beans.factory.BeanCreationException;
import org.xuanspring.beans.factory.config.ConfigurableBeanFactory;
import org.xuanspring.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Leo xuan
 * @date 2018/8/14
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements BeanDefinitionRegistry,ConfigurableBeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);
    private ClassLoader beanClassLoader;

    public DefaultBeanFactory() {

    }

    @Override
    public Object getBean(String beanID) {
        BeanDefinition bd = getBeanDefinition(beanID);
        if (bd == null ) {
            return null;
        }
        if(bd.isSingleton()){
            Object bean = this.getSingleton(beanID);
            if (bean == null){
                bean = createBean(bd);
                this.registerSingleton(beanID,bean);
            }
            return bean;
        }
        return createBean(bd);
    }

    private Object createBean(BeanDefinition bd) {
        ClassLoader classLoader = this.getBeanClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = classLoader.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for "+ beanClassName +" failed",e);
        }
    }
    @Override
    public BeanDefinition getBeanDefinition(String beanID) {
        return beanDefinitionMap.get(beanID);
    }

    @Override
    public void registerBeanDefinition(String beanID, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanID,bd);
    }

    @Override
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }

}
