package com.empresa.postgresqlspringbootjwt10032023.responses;

import java.util.List;

import com.empresa.postgresqlspringbootjwt10032023.models.Clinic;

public class ClinicResponse {
    private boolean sqlExecute;
    private String sqlResponse;
    private List<Clinic> clinics;

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

    public List<Clinic> getClinics() {
        return this.clinics;
    }

    public void setClinics(List<Clinic> clinics) {
        this.clinics = clinics;
    }
}