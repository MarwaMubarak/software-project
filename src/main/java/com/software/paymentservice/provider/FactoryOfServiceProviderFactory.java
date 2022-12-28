package com.software.paymentservice.provider;

public class FactoryOfServiceProviderFactory {
	
	public ServiceProviderFactory create(String  serviceProviderFactoryType) {
		
		if(serviceProviderFactoryType.equals("DonationService"))
			return new DonationProviderFactory();
		else if(serviceProviderFactoryType.equals("LandlineService"))
			return new LandlineProviderFactory();
		else if(serviceProviderFactoryType.equals("MobileRechargeService"))
			return new MobileProviderFactory();
		else if(serviceProviderFactoryType.equals("InternetPaymentService"))
			return new InternetProviderFactory();
		
		return null;
	}
	

}
