package com.software.paymentservice.provider;

public class MonthlyReceiptLandline extends ServiceProvider {
	String phoneNumber;
	@Override
	public String getName() {
		return "MonthlyReceiptLandline";
	}
	
	
	@Override
	public void setInfo(double amount, String info) {
		phoneNumber = info;
		money+=amount;
	}

	
}
