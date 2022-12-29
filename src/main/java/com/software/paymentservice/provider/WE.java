package com.software.paymentservice.provider;

public class WE extends ServiceProvider {
    String phoneNumber;

    @Override
    public String getName() {
        return "WE";
    }

    @Override
    public void setInfo(double amount, String info) {
        phoneNumber = info;
        money += amount;

    }


}
