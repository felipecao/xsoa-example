package br.unirio.xsoa.endpoint.core;

import br.unirio.xsoa.endpoint.core.domain.SiteWSO;

/**
 * Created with IntelliJ IDEA.
 * User: felipe
 * Date: 7/3/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class DownloadResponse {
    SiteWSO[] sites;

    public DownloadResponse(SiteWSO[] sites) {
        this.sites = sites;
    }

    public DownloadResponse() {
    }

    public SiteWSO[] getSites() {
        return sites;
    }

    public void setSites(SiteWSO[] sites) {
        this.sites = sites;
    }
}
