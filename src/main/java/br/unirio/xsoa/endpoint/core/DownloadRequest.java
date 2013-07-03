package br.unirio.xsoa.endpoint.core;

/**
 * Created with IntelliJ IDEA.
 * User: felipe
 * Date: 7/3/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class DownloadRequest {
    private String user;

    public DownloadRequest() {
    }

    public DownloadRequest(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
