package com.software.paymentservice.service;

public abstract class ServiceDecorator extends Service{
    Service service;
    double newDiscount=0.0;
    
    ServiceDecorator(Service service){
        this.service= service;
    	//this.id = service.id;
    	this.cost = service.cost;
    	this.payment=service.payment;
        this.discount=service.discount;
    	this.provider= service.provider;    
    	this.cash=service.cash;
        
    }
    
  
}
