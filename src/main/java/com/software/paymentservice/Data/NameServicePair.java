package com.software.paymentservice.Data;

import  com.software.paymentservice.service.Service;

public class NameServicePair{
	public String name;
	public Service service; 
	public NameServicePair(String name,Service service ){
		this.name = name;
		this.service = service;
	}
}