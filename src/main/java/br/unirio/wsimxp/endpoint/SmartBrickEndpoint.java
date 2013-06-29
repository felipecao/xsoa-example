package br.unirio.wsimxp.endpoint;

import br.unirio.wsimxp.entity.Site;
import br.unirio.wsimxp.entity.User;
import br.unirio.wsimxp.service.ISiteService;
import br.unirio.wsimxp.spring.BeanRetriever;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import java.util.Set;

@WebService
public class SmartBrickEndpoint {

    @Resource
    private WebServiceContext context;

    public void webMethod(){

    }

    private ISiteService getSiteService(){
        ServletContext servletContext = (ServletContext) context.getMessageContext().get("javax.xml.ws.servlet.context");
        return (ISiteService) BeanRetriever.getBean(servletContext, ISiteService.class);
    }
}
