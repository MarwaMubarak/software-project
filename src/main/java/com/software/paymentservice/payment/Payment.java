package com.software.paymentservice.payment;

import com.software.paymentservice.response.Response;
import org.springframework.stereotype.Service;

public interface Payment {
    String getName();
    Response pay(double discount, double amount);

    double getTaxes();
}
