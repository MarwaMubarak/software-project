package com.software.paymentservice.Data;
import  com.software.paymentservice.user.*;

import java.util.*;

import  com.software.paymentservice.provider.ServiceProvider;
import  com.software.paymentservice.service.*;

import  com.software.paymentservice.service.*;

public class SavedData {
	
	public  Map<String, Map<Integer,ServiceStatePair>> usersCompleteService = new HashMap<String,Map<Integer,ServiceStatePair>>(); 
	
	public Map<String, Service> services = new HashMap<String, Service>();
	
	private Map<Integer,User> refundServices=new HashMap<Integer, User>();
		
	private Map<String, User> userData = new HashMap<String, User>();
	
	private static SavedData savedData = null;
	
	
	
	public Map<Integer,User> getRefundService(){
		return refundServices;
	}
	private SavedData() {
		services.put("MobileRecharge", new MobileRechargeService());
		services.put("InternetPayment", new InternetPaymentService());
		services.put("Landline", new LandlineService());
		services.put("Donation", new DonationService());
	}
	
	
	public static SavedData getObj(){
		if(savedData==null)savedData = new SavedData();
		
		return savedData;
	}
	
	public Map<String, User> getUserData(){
		return userData;
	}
	
	public Map<Integer,ServiceStatePair> getUsersCompleteService() {
		return usersCompleteService.get(Account.user.email);
	}
	
	public void setUsersCompleteService(Map<Integer,ServiceStatePair> userCompliete) {
		usersCompleteService.put(Account.user.email,userCompliete);
	}

	
	
}
