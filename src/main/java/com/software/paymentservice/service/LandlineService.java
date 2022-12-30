package com.software.paymentservice.service;

import java.util.Scanner;

import com.software.paymentservice.payment.PaymentFactory;
import com.software.paymentservice.provider.LandlineProviderFactory;
import com.software.paymentservice.provider.MobileProviderFactory;
import com.software.paymentservice.provider.ServiceProvider;
import com.software.paymentservice.provider.ServiceProviderFactory;

public class LandlineService extends Service {

    @Override
    public String getName() {

        return "LandlineService";
    }

}

