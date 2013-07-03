package br.unirio.xsoa.spring;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

public class BeanRetriever {

    public static Object getBean(ServletContext servletContext, Class cls){
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return webApplicationContext.getAutowireCapableBeanFactory().getBean(cls);
    }
}
