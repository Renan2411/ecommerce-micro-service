package com.example.estoqueapi.utils;

import org.springframework.stereotype.Component;

@Component
public class UrlBuilderUtils {

    private String baseUrl;
    private String path;

    public static UrlBuilderUtils Builder() {
        return new UrlBuilderUtils();
    }

    public UrlBuilderUtils baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public UrlBuilderUtils path(String path) {
        this.path = path;
        return this;
    }

    public String build() {
        return this.baseUrl + this.path;
    }

}
