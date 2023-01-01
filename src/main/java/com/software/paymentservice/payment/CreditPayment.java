package com.software.paymentservice.payment;

import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.response.Response;


public class CreditPayment implements Payment {

    @Override
    public Response pay(double discount, double amount) {

        double amountAfterDiscounts = (1 - discount) * amount;
        if (AccountController.getUserController().getUserModel().getMyCreditCard().getBalance() >= amountAfterDiscounts + getTaxes()) {
            AccountController.getUserController().getUserModel().getMyCreditCard().spend(amountAfterDiscounts + getTaxes());
            return new Response("Done Successfully...", amountAfterDiscounts + getTaxes());
        } else {
            return new Response("There is Not Enough Money", -1);
        }
    }

    @Override
    public String getName() {
        return "CreditCardPayment";
    }

    @Override
    public double getTaxes() {
        return 5;
    }


}
