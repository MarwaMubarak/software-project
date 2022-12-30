package com.software.paymentservice.provider;

import com.software.paymentservice.response.Response;

public class Orange extends ServiceProvider{
	private String phoneNumber;
	@Override
	public String getName() {
		return "Orange";
	}
	@Override
	public Response setInfo(double amount, String info) {
		phoneNumber = info;
		setMoney(getMoney()+amount);
		return new Response("Done successfully..","");

	}

}
