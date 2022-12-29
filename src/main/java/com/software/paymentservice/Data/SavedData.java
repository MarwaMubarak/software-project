package com.software.paymentservice.Data;
import com.software.paymentservice.account.AccountController;
import  com.software.paymentservice.user.*;

import java.util.*;

import  com.software.paymentservice.service.*;

public class SavedData {

	public  Map<String, Map<Integer,ServiceStatePair>> usersCompleteService = new HashMap<String,Map<Integer,ServiceStatePair>>();

	public Map<String, Service> services = new HashMap<String, Service>();

	private Map<Integer, UserController> refundServices=new HashMap<Integer, UserController>();

	private Map<String, UserController> userData = new HashMap<String, UserController>();

	public Map<String, String> getWalletTransactions() {
		return walletTransactions;
	}

	private Map<String,String>walletTransactions=new HashMap<>();

	private static SavedData savedData = null;



	public Map<Integer, UserController> getRefundService(){
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

	public Map<String, UserController> getUserData(){
		return userData;
	}

	public Map<Integer,ServiceStatePair> getUsersCompleteService() {
		return usersCompleteService.get(AccountController.userController.getUserModel().getEmail());
	}

	public void setUsersCompleteService(Map<Integer,ServiceStatePair> userCompliete) {
		usersCompleteService.put(AccountController.userController.getUserModel().getEmail(),userCompliete);
	}



}
