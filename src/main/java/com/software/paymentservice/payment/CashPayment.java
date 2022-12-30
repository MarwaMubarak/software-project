package com.software.paymentservice.payment;

import com.software.paymentservice.response.Response;

public class CashPayment implements Payment {

    @Override
    public Response pay(double discount, double amount) {
        double amountAfterDiscounts = (1 - discount) * amount;
        return new Response("Done..", amountAfterDiscounts);
    }

    @Override
    public String getName() {
        return "CashPayment";
    }

    @Override
    public double getTaxes() {
        return 0;
    }


}
