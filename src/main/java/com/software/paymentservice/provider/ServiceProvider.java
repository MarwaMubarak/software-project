package com.software.paymentservice.provider;

import com.software.paymentservice.response.Response;

public abstract class ServiceProvider {
    double money = 0.0;

    public abstract String getName();


    public abstract Response setInfo(double amount, String info);
}

