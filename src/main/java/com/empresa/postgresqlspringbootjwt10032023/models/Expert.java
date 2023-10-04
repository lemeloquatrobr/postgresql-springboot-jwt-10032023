package com.empresa.postgresqlspringbootjwt10032023.models;

import java.util.Date;

public class Expert {
    private int id;
    private String expert;
    private Date createdAt;
    private Date updatedAt;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpert() {
        return this.expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}