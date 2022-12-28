package com.software.paymentservice.provider;

import java.util.Scanner;

public class MonthlyReceiptLandline extends ServiceProvider {
	String phoneNumber;
	@Override
	public String getName() {
		return "MonthlyReceiptLandline";
	}
	
	
	@Override
	public void setInfo(double amount) {
		System.out.println("Enter Phone Number: ");
		phoneNumber=new Scanner(System.in).next();
		money+=amount;
	}

	
}
