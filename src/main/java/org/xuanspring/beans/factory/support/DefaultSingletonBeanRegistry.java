package org.xuanspring.beans.factory.support;

import org.xuanspring.beans.factory.config.SingletonBeanFactory;
import org.xuanspring.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Leo xuan
 * @date 2018/8/14
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanFactory{

    public static final Map<String,Object> singleMap = new ConcurrentHashMap<String,Object>(64);

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        Assert.notNull(beanName,"'beanName' must not be null");

        Object obj = singleMap.get(beanName);
        if (obj !=null ) {
            throw new IllegalStateException("Could not register object [" + singletonObject +
                    "] under bean name '" + beanName + "': there is already object [" + obj + "] bound");
        }
        this.singleMap.put(beanName,singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return singleMap.get(beanName);
    }
}
