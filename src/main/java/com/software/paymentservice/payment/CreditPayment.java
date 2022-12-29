package com.software.paymentservice.payment;

import java.util.Scanner;

import com.software.paymentservice.account.AccountController;


public class CreditPayment implements Payment {

    @Override
    public double pay(double discount, double amount) {

        double amountAfterDiscounts = (1 - discount) * amount;
        if (AccountController.userController.getUserModel().getMyCreditCard().getBalance() >= amountAfterDiscounts + getTaxes()) {
            AccountController.userController.getUserModel().getMyCreditCard().spend(amountAfterDiscounts + getTaxes());
            return amountAfterDiscounts + getTaxes();
        } else {
            System.out.println("There is Not Enough Money");
            return -1;
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
