package com.software.paymentservice.provider;

import java.util.Scanner;

public class DonationProviderFactory implements ServiceProviderFactory{
	@Override
	public ServiceProvider create() {
		System.out.println("Choose Your Provider:");
		System.out.println("Press 1. Canser Hospitals");
		System.out.println("Press 2. Schools");
		System.out.println("Press 3. NGOs");
		String  providerType = new Scanner(System.in).next();
		while(!(providerType.equals("1")||providerType.equals("2")||providerType.equals("3"))) {
			System.out.println("Invalid Input!!");
			System.out.println("Choose Your Provider Again:");
			System.out.println("Press 1. Canser Hospitals");
			System.out.println("Press 2. Schools");
			System.out.println("Press 3. NGOs");
			providerType = new Scanner(System.in).next();
		}
		
		if (providerType.equals("1")) {
			return new CancerHospital();
		}else if (providerType.equals("2")) {
			return new Schools();
		}else if (providerType.equals("3")) {
			return new NGOs();
		}
		return null;
	}
}
