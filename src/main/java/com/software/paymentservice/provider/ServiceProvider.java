package com.software.paymentservice.provider;

import com.software.paymentservice.response.Response;

public abstract class ServiceProvider {


    private double money = 0.0;

    public abstract String getName();

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public abstract Response setInfo(double amount, String info);
}

