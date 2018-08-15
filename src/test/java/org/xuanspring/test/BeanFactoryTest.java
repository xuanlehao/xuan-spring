package org.xuanspring.test;

import org.junit.Before;
import org.junit.Test;
import org.xuanspring.beans.BeanDefinition;
import org.xuanspring.beans.factory.support.DefaultBeanFactory;
import org.xuanspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.xuanspring.core.io.ClassPathResource;
import service.test.PetStoreService;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * @author Leo xuan
 * @date 2018/8/14
 */
public class BeanFactoryTest {

    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp(){
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);

    }
    @Test
    public void testGetBean() {

        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));

        BeanDefinition bd = factory.getBeanDefinition("petStore");

        assertTrue(bd.isSingleton());

        assertFalse(bd.isPrototype());

        assertEquals(BeanDefinition.SCOPE_DEFAULT,bd.getScope());

        assertEquals("service.test.PetStoreService",bd.getBeanClassName());

        PetStoreService petStore = (PetStoreService)factory.getBean("petStore");

        assertNotNull(petStore);

        PetStoreService petStore1 = (PetStoreService)factory.getBean("petStore");

        assertTrue(petStore.equals(petStore1));
    }
}
