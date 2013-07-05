package br.unirio.xsoa.endpoint.nonfunctional;

import br.unirio.xsoa.wsobjects.DownloadRequest;
import br.unirio.xsoa.wsobjects.DownloadResponse;
import br.unirio.xsoa.wsobjects.SmartBrickEndpoint;
import br.unirio.xsoa.wsobjects.SmartBrickEndpointService;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class NonFunctionalSteps {

    String serviceEndpointUrl = "http://localhost:8080/xsoa/SmartBrickEndpointService";
    DownloadResponse r = null;
    String responseAsSoapEnvelope = null;

    @When("^\"([^\"]*)\" user requests his sites$")
    public void user_requests_his_sites(String userName) throws Throwable {
        DownloadRequest request = new DownloadRequest();
        request.setUser(userName);
        r = getPort().downloadSites(request);
    }

    @Then("^response size is not larger than \"([^\"]*)\"KB$")
    public void response_size_is_not_larger_than_KB(Integer maxSize) throws Throwable {
        assertNotNull(r);
        assertTrue((maxSize * 1000) > responseAsSoapEnvelope.length());
    }

    private SmartBrickEndpoint getPort(){
        SmartBrickEndpointService s = new SmartBrickEndpointService();
        SmartBrickEndpoint port = s.getSmartBrickEndpointPort();
        BindingProvider bp = (BindingProvider) port;
        Binding binding = bp.getBinding();

        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, serviceEndpointUrl);

        // Add the logging handler
        List<Handler> handlerList = binding.getHandlerChain();
        if (handlerList == null){
            handlerList = new ArrayList();
        }

        handlerList.add(new LogicalHandler<LogicalMessageContext>() {

            /*
             * @see http://wangxiangblog.blogspot.com.br/2013/02/develop-web-service-with-jaxws-print.html
             */
            @Override
            public boolean handleMessage(LogicalMessageContext messageContext) {
                boolean isInbound = ((Boolean) messageContext
                        .get(LogicalMessageContext.MESSAGE_OUTBOUND_PROPERTY))
                        .booleanValue();

                try {
                    LogicalMessage lm = ((LogicalMessageContext) messageContext).getMessage();
                    if (lm != null) {
                        Source source = lm.getPayload();
                        if (source != null && !isInbound) {
                            responseAsSoapEnvelope = getSourceAsString(source);
                        }
                    }
                    else {
                        System.out.println("WARN: No Message was present");
                    }
                } catch (Exception e) {
                    System.out.println("ERROR: Exception while dumping soap message." + e);
                }

                return true;
            }

            @Override
            public boolean handleFault(LogicalMessageContext messageContext) {
                // do nothing
                return false;
            }

            @Override
            public void close(MessageContext messageContext) {
                // do nothing
            }

            private String getSourceAsString(Source s) throws Exception {

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                OutputStream out = new ByteArrayOutputStream();
                StreamResult streamResult = new StreamResult();
                streamResult.setOutputStream(out);
                transformer.transform(s, streamResult);

                return streamResult.getOutputStream().toString();
            }
        });


        binding.setHandlerChain(handlerList);

        return port;
    }
}
