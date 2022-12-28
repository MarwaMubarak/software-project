package com.software.paymentservice.provider;

public class CancerHospital extends ServiceProvider{

	@Override
	public String getName() {
		return "CancerHospital";
	}

	@Override
	public void setInfo(double amount) {
		money+=amount;		
	}



}
