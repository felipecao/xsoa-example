package br.unirio.wsimxp.spring;

import br.unirio.wsimxp.service.ISiteService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

public class BeanRetriever {

    public static Object getBean(ServletContext servletContext, Class cls){
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return webApplicationContext.getAutowireCapableBeanFactory().getBean(cls);
    }
}
