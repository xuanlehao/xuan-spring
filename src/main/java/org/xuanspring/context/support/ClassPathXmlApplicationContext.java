package org.xuanspring.context.support;


import org.xuanspring.core.io.ClassPathResource;
import org.xuanspring.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	public ClassPathXmlApplicationContext(String configFile) {
		super(configFile);
		
	}

	@Override
	protected Resource getResourceByPath(String path) {
		
		return new ClassPathResource(path,this.getBeanClassLoader());
	}

}
