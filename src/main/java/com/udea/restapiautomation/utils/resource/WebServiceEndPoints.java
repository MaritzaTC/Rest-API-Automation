package com.udea.restapiautomation.utils.resource;

import com.udea.restapiautomation.utils.constants.Endpoints;

public enum WebServiceEndPoints {

    URI(Endpoints.URL_USERS);

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
