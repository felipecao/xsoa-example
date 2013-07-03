package br.unirio.xsoa.endpoint;

import br.unirio.xsoa.endpoint.core.DownloadRequest;
import br.unirio.xsoa.endpoint.core.DownloadResponse;

/**
 * Created with IntelliJ IDEA.
 * User: felipe
 * Date: 7/3/13
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
public interface ISmartBrickEndpoint {

    DownloadResponse download(DownloadRequest r);
}
