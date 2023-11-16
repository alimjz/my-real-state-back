package com.mavaratech.myrealstate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.myestate")
public class PropertySource {
    private String dsdpUrl;
    private String tokenUrl;
    private String otpUrl;

    public String getOtpUrl() {
        return otpUrl;
    }

    public void setOtpUrl(String otpUrl) {
        this.otpUrl = otpUrl;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getDsdpUrl() {
        return dsdpUrl;
    }

    public void setDsdpUrl(String dsdpUrl) {
        this.dsdpUrl = dsdpUrl;
    }
}
