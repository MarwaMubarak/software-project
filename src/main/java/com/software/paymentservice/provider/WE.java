package com.software.paymentservice.provider;

import java.util.Scanner;

public class WE extends ServiceProvider{
	String phoneNumber;
	@Override
	public String getName() {
		return "WE";
	}
	@Override
	public void setInfo(double amount) {
		System.out.println("Enter Phone Number: ");
		phoneNumber=new Scanner(System.in).next();
		money+=amount;
		
	}

	
}
