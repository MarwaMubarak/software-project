package com.software.paymentservice.provider;

public class NGOs extends ServiceProvider {

	@Override
	public String getName() {
		return "NGOs";
	}

	@Override
	public void setInfo(double amount) {
		money+=amount;
		
	}

}
