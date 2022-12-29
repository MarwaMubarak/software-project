package com.software.paymentservice.provider;

public class Etisalat extends ServiceProvider{
	String phoneNumber;
	@Override
	public String getName() {
		return "Etisalat";
	}
	@Override
	public void setInfo(double amount, String info) {
		phoneNumber = info;
		money+=amount;		
	}
	
}
