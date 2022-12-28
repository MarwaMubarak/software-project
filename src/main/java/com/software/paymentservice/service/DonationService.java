package com.software.paymentservice.service;

import java.util.Scanner;

import  com.software.paymentservice.payment.PaymentFactory;
import  com.software.paymentservice.provider.DonationProviderFactory;
import  com.software.paymentservice.provider.ServiceProvider;
import  com.software.paymentservice.provider.ServiceProviderFactory;

public class DonationService extends Service {
	

@Override
public String getName() {
	
	return "DonationService";
}

}
