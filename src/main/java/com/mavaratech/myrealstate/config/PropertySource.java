package com.mavaratech.myrealstate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.myestate")
public class PropertySource {
    private String dsdpUrl;

    public String getDsdpUrl() {
        return dsdpUrl;
    }

    public void setDsdpUrl(String dsdpUrl) {
        this.dsdpUrl = dsdpUrl;
    }
}
