package com.software.paymentservice.discount;

import java.util.Scanner;

public class DiscountFactory {

	public Discount create(String choice) {
		if(choice.equals("1"))
			return new SpecificDiscount();
		else if(choice.equals("2"))
			return new OverAllDiscount();
		
		return null;
	}
	
}
