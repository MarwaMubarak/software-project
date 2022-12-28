package com.software.paymentservice.service;

import  com.software.paymentservice.payment.PaymentFactory;
import  com.software.paymentservice.provider.FactoryOfServiceProviderFactory;
import  com.software.paymentservice.provider.ServiceProvider;
import  com.software.paymentservice.provider.ServiceProviderFactory;
import  com.software.paymentservice.user.Account;

public class DiscountDecorator extends ServiceDecorator{
    public DiscountDecorator(Service service) {
        super(service);
        
    }
    
    
    public void setDiscount(int discount) {
    	newDiscount =discount/100.0;
    	this.discount=newDiscount+super.getDiscounts();
    }
    
    
	@Override
	public String getName() {
		return service.getName();
	}

    
    
    
   
    


}
