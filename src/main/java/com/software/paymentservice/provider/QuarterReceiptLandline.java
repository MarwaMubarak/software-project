package com.software.paymentservice.provider;

public class QuarterReceiptLandline extends ServiceProvider{
	String phoneNumber;
	@Override
	public String getName() {
		return "QuarterReceiptLandline";
	}
	@Override
	public void setInfo(double amount, String info) {
		phoneNumber = info;
		money+=amount;
		
	}

	
}
