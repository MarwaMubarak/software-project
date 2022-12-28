package com.software.paymentservice.discount;

import java.util.Scanner;

public class DiscountFactory {

	public Discount create() {
		System.out.println("Press 1. To Add Discount to Specific Service ");
		System.out.println("Press 2. To Add Discount to All Services ");
		String choice=new Scanner(System.in).next();
		while(!(choice.equals("1")||choice.equals("2"))) {
			System.out.println("Invalid Input!!");
			System.out.println("Press 1. To Add Discount to Specific Service ");
			System.out.println("Press 2. To Add Discount to All Services ");
			choice=new Scanner(System.in).next();
		}
		if(choice.equals("1"))
			return new SpecificDiscount();
		else if(choice.equals("2"))
			return new OverAllDiscount();
		
		return null;
	}
	
}
