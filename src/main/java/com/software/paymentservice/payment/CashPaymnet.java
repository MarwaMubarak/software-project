package com.software.paymentservice.payment;

import java.util.Scanner;

public class CashPaymnet implements Payment{
	public double amount=0.0;
	@Override
	public double pay(double discount) {
		System.out.println("Enter The Amount: ");
		amount = new Scanner(System.in).nextDouble();
		while(amount<0.0) {
			System.out.println("Invalid Input!!");
			System.out.println("Enter The Amount Again: ");
			amount= new Scanner(System.in).nextDouble();
		}
		double amountAfterDiscounts = (1-discount)*amount;
		return amountAfterDiscounts;
	}
	
	@Override
	public String getName() {
		return "CashPayment";
		
	}

	@Override
	public double getTaxes() {
		return 0;
	}

	@Override
	public double getAmount() {
		return amount;
	}

}
