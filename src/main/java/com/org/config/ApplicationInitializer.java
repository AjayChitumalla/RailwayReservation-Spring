package com.org.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class[] classArray = {ApplicationConfig.class};
		return classArray;
	}

	@Override
	protected String[] getServletMappings() {
		String mapping[] = {"/"};
		return mapping;
	}

}
