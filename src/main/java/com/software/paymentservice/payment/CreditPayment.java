package com.software.paymentservice.payment;

import java.util.Scanner;
import java.util.spi.ResourceBundleProvider;

import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.response.Response;


public class CreditPayment implements Payment {

    @Override
    public Response pay(double discount, double amount) {

        double amountAfterDiscounts = (1 - discount) * amount;
        if (AccountController.userController.getUserModel().getMyCreditCard().getBalance() >= amountAfterDiscounts + getTaxes()) {
            AccountController.userController.getUserModel().getMyCreditCard().spend(amountAfterDiscounts + getTaxes());
            return new Response("Done Successfully...",amountAfterDiscounts + getTaxes());
        } else {
            //System.out.println("There is Not Enough Money");
            return new Response("There is Not Enough Money",-1);
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
