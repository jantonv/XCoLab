package org.xcolab.util.http.client;

import org.xcolab.util.http.RequestUtils;
import org.xcolab.util.http.UriProvider;
import org.xcolab.util.http.client.interfaces.HttpEndpoint;

public class RestService implements HttpEndpoint {

    private static final String SCHEMA = "HTTP://";
    private static final String DEFAULT_HOST_NAME = "localhost";
    private static final String DEFAULT_PORT = RequestUtils.getServicesPort();

    private final String serviceName;
    private final UriProvider uriProvider;

    public RestService(String serviceName) {
        this.serviceName = serviceName;
        uriProvider = getBaseUrl(DEFAULT_HOST_NAME, DEFAULT_PORT);
    }

    @Override
    public UriProvider getBaseUrl() {
        return uriProvider;
    }

    public UriProvider getBaseUrl(String hostName, String port) {
        return new UriProvider(SCHEMA + hostName + ":" + port + "/" + serviceName);
    }
}
