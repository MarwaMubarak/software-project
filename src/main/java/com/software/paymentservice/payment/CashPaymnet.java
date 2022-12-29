package com.software.paymentservice.payment;

import java.util.Scanner;

public class CashPaymnet implements Payment {
    @Override
    public double pay(double discount, double amount) {

        double amountAfterDiscounts = (1 - discount) * amount;
        return amountAfterDiscounts;
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
