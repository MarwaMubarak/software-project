package com.software.paymentservice.provider;

import com.software.paymentservice.response.Response;

public class QuarterReceiptLandline extends ServiceProvider{
	String phoneNumber;
	@Override
	public String getName() {
		return "QuarterReceiptLandline";
	}
	@Override
	public Response setInfo(double amount, String info) {
		phoneNumber = info;
		money+=amount;
		return new Response("Done successfully..","");

	}

	
}
