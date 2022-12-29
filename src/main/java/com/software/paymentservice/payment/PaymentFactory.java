package com.software.paymentservice.payment;

import java.util.Scanner;

public class PaymentFactory {
    public Payment create(int ID) {

        if (ID == 1)
            return new CreditPayment();
        else if (ID == 2)
            return new WalletPayment();
        else if (ID == 3)
            return new CashPaymnet();
        else
            return null;

    }
}
