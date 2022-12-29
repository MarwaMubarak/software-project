package com.software.paymentservice.provider;

public class Vodafone extends ServiceProvider{
	String phoneNumber;
	@Override
	public String getName() {
		return "Vodafone";
	}

	@Override
	public void setInfo(double amount, String info) {
		phoneNumber = info;
		money+=amount;
		
	}
}
