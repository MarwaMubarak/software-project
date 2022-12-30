package com.software.paymentservice.provider;

import com.software.paymentservice.response.Response;

public class MonthlyReceiptLandline extends ServiceProvider {
    private String phoneNumber;

    @Override
    public String getName() {
        return "MonthlyReceiptLandline";
    }


    @Override
    public Response setInfo(double amount, String info) {
        phoneNumber = info;
        setMoney(getMoney() + amount);
        return new Response("Done Successfully..", "");
    }


}
