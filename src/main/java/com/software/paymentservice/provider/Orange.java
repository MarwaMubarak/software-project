package com.software.paymentservice.provider;

public class Orange extends ServiceProvider{
	String phoneNumber;
	@Override
	public String getName() {
		return "Orange";
	}
	@Override
	public void setInfo(double amount, String info) {
		phoneNumber = info;
		money+=amount;
	}

}
