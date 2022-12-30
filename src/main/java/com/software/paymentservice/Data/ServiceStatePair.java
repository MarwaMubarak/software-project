package com.software.paymentservice.Data;

import com.software.paymentservice.service.Service;

public class ServiceStatePair {
    private Integer state;
    public Service service;

    public ServiceStatePair(Integer state, Service service) {
        this.state = state;
        this.service = service;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

}
