package com.software.paymentservice.payment;

public interface Payment {
    String getName();


    double pay(double discount, double amount);

    double getTaxes();
}
