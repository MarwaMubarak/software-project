package com.software.paymentservice.provider;

import com.software.paymentservice.response.Response;

public class Vodafone extends ServiceProvider{
	String phoneNumber;
	@Override
	public String getName() {
		return "Vodafone";
	}

	@Override
	public Response setInfo(double amount, String info) {
		phoneNumber = info;
		money+=amount;
		return new Response("Done successfully..","");

	}
}
