package com.example.demo.models.entites;


import java.io.Serializable;

public class Base implements Serializable {

    private String id;

    private boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
