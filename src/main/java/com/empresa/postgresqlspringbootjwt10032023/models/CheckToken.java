package com.empresa.postgresqlspringbootjwt10032023.models;

public class CheckToken {
    private Boolean statusToken;
    private String statusError;

    public Boolean getStatusToken() {
        return this.statusToken;
    }

    public void setStatusToken(Boolean statusToken) {
        this.statusToken = statusToken;
    }

    public String getStatusError() {
        return this.statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }
}