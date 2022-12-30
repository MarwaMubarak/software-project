package com.software.paymentservice.provider;

import com.software.paymentservice.response.Response;

public class Schools extends ServiceProvider {
    @Override
    public String getName() {
        return "Schools";
    }


    @Override
    public Response setInfo(double amount, String info) {
        setMoney(getMoney() + amount);
        return new Response("Done successfully..", "");
    }
}
