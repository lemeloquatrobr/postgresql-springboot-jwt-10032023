package com.empresa.postgresqlspringbootjwt10032023.responses;

import java.util.List;

import com.empresa.postgresqlspringbootjwt10032023.models.Expert;

public class ExpertResponse {
    private boolean sqlExecute;
    private String sqlResponse;
    private List<Expert> experts;

    public boolean getSqlExecute() {
        return this.sqlExecute;
    }

    public void setSqlExecute(boolean sqlExecute) {
        this.sqlExecute = sqlExecute;
    }

    public String getSqlResponse() {
        return this.sqlResponse;
    }

    public void setSqlResponse(String sqlResponse) {
        this.sqlResponse = sqlResponse;
    }

    public List<Expert> getExperts() {
        return this.experts;
    }

    public void setExperts(List<Expert> experts) {
        this.experts = experts;
    }
}