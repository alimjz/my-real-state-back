package com.mavaratech.myrealstate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.myestate")
public class PropertySource {
    private String dsdpUrl;
    private String tokenUrl;
    private String otpUrl;
    private String estateOwnersUrl;
    private String confirmDocumentUrl;

    public String getConfirmDocumentUrl() {
        return confirmDocumentUrl;
    }

    public void setConfirmDocumentUrl(String confirmDocumentUrl) {
        this.confirmDocumentUrl = confirmDocumentUrl;
    }

    public String getEstateOwnersUrl() {
        return estateOwnersUrl;
    }

    public void setEstateOwnersUrl(String estateOwnersUrl) {
        this.estateOwnersUrl = estateOwnersUrl;
    }

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
