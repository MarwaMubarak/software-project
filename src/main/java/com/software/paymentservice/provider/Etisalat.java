package com.software.paymentservice.provider;

import com.software.paymentservice.response.Response;

public class Etisalat extends ServiceProvider{
	String phoneNumber;
	@Override
	public String getName() {
		return "Etisalat";
	}
	@Override
	public Response setInfo(double amount, String info) {
		phoneNumber = info;
		money+=amount;
		return new Response("Done successfully..","");
	}
	
}
