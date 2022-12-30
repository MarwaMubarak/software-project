package com.software.paymentservice.Data;

import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.user.*;

import java.util.*;

import com.software.paymentservice.service.*;

public class SavedData {

    public Map<String, Map<Integer, ServiceStatePair>> usersCompleteService;

    public Map<String, Service> services;

    private Map<Integer, UserController> refundServices;

    public Map<String, ArrayList<String>> getRefundTransactions() {
        return refundTransactions;
    }

    private Map<String, ArrayList<String>> refundTransactions;

    private Map<String, UserController> userData;

    public Map<String, ArrayList<String>> getWalletTransactions() {
        return walletTransactions;
    }

    private Map<String, ArrayList<String>> walletTransactions;

    private static SavedData savedData = null;


    public Map<Integer, UserController> getRefundService() {
        return refundServices;
    }

    private SavedData() {
        usersCompleteService = new HashMap<String, Map<Integer, ServiceStatePair>>();
        services = new HashMap<String, Service>();
        refundServices = new HashMap<Integer, UserController>();
        userData = new HashMap<String, UserController>();
        walletTransactions = new HashMap<>();
        refundTransactions=new HashMap<>();
        services.put("MobileRecharge", new MobileRechargeService());
        services.put("InternetPayment", new InternetPaymentService());
        services.put("Landline", new LandlineService());
        services.put("Donation", new DonationService());
    }


    public static SavedData getObj() {
        if (savedData == null) savedData = new SavedData();

        return savedData;
    }

    public Map<String, UserController> getUserData() {
        return userData;
    }

    public Map<Integer, ServiceStatePair> getUserCompleteService() {
        return usersCompleteService.get(AccountController.userController.getUserModel().getEmail());
    }

    public Map<String, Map<Integer, ServiceStatePair>> getUsersCompleteService() {
        return usersCompleteService;
    }

    public void setUsersCompleteService(Map<Integer, ServiceStatePair> userCompliete) {
        usersCompleteService.put(AccountController.userController.getUserModel().getEmail(), userCompliete);
    }


}
