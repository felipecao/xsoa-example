package br.unirio.xsoa.endpoint.core;

import br.unirio.xsoa.endpoint.ISmartBrickEndpoint;
import br.unirio.xsoa.endpoint.core.domain.SiteWSO;
import br.unirio.xsoa.entity.Site;
import br.unirio.xsoa.entity.User;
import br.unirio.xsoa.service.ISiteService;
import br.unirio.xsoa.spring.BeanRetriever;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import java.util.Set;

@WebService
public class SmartBrickEndpoint implements ISmartBrickEndpoint {

    @Resource
    private WebServiceContext context;

    private ISiteService siteService;

    public SmartBrickEndpoint() {
    }

    @Autowired
    public SmartBrickEndpoint(ISiteService siteService) {
        this.siteService = siteService; // injected only during tests.
        // At runtime, JAX-WS endpoints don't have access to Spring context
    }

    @Override
    @WebMethod
    public @WebResult DownloadResponse downloadSites(@WebParam DownloadRequest r) {
        ISiteService siteService = getSiteService();
        Set<Site> sites = siteService.findByUser(new User(r.getUser()));
        return new DownloadResponse(convertFrom(sites));
    }

    private ISiteService getSiteService(){
        if(null == siteService){ // if it's not a test...
            ServletContext servletContext = (ServletContext) context.getMessageContext().get("javax.xml.ws.servlet.context");
            return (ISiteService) BeanRetriever.getBean(servletContext, ISiteService.class);
        }
        return siteService;
    }

    private SiteWSO[] convertFrom(Set<Site> sites){

        if(null == sites || 0 == sites.size()){
            return null;
        }

        SiteWSO[] ret = new SiteWSO[sites.size()];
        int i=0;

        for (Site s: sites){
            ret[i++] = SiteWSO.fromEntity(s);
        }

        return ret;
    }
}
