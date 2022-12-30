package com.software.paymentservice.Data;

import com.software.paymentservice.service.Service;

public class NameServicePair {


    private String name;
    private Service service;

    public NameServicePair(String name, Service service) {
        this.name = name;
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}