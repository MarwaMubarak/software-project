package com.software.paymentservice.provider;

public abstract class ServiceProvider {
	double money=0.0;
	public abstract String getName();
	public abstract void setInfo(double amount);
}

