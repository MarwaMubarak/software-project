package com.software.paymentservice.Data;

import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.payment.Payment;
import com.software.paymentservice.provider.ServiceProvider;
import com.software.paymentservice.service.*;
import com.software.paymentservice.user.UserController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SavedData {

    private static SavedData savedData = null;
    private String baseUrl = "http://localhost:8080";
    private Map<String, Map<Integer, ServiceStatePair>> usersCompleteService;
    private Map<String, Service> services;
    private Payment payment;
    private ServiceProvider serviceProvider;
    private Map<Integer, UserController> refundServices;
    private Map<String, ArrayList<String>> refundTransactions;
    private Map<String, UserController> userData;
    private Map<String, ArrayList<String>> walletTransactions;

    private SavedData() {
        usersCompleteService = new HashMap<String, Map<Integer, ServiceStatePair>>();
        services = new HashMap<String, Service>();
        refundServices = new HashMap<Integer, UserController>();
        userData = new HashMap<String, UserController>();
        walletTransactions = new HashMap<>();
        refundTransactions = new HashMap<>();
        services.put("MobileRecharge", new MobileRechargeService());
        services.put("InternetPayment", new InternetPaymentService());
        services.put("Landline", new LandlineService());
        services.put("Donation", new DonationService());
    }

    public static SavedData getObj() {
        if (savedData == null) savedData = new SavedData();

        return savedData;
    }


    public Map<Integer, UserController> getRefundServices() {
        return refundServices;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Map<String, ArrayList<String>> getWalletTransactions() {
        return walletTransactions;
    }

    public Map<String, ArrayList<String>> getRefundTransactions() {
        return refundTransactions;
    }

    public Map<Integer, UserController> getRefundService() {
        return refundServices;
    }

    public Map<String, Service> getServices() {
        return services;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Map<String, UserController> getUserData() {
        return userData;
    }

    public Map<Integer, ServiceStatePair> getUserCompleteService() {
        return usersCompleteService.get(AccountController.getUserController().getUserModel().getEmail());
    }

    public Map<String, Map<Integer, ServiceStatePair>> getUsersCompleteService() {
        return usersCompleteService;
    }

    public void setUsersCompleteService(Map<Integer, ServiceStatePair> userCompliete) {
        usersCompleteService.put(AccountController.getUserController().getUserModel().getEmail(), userCompliete);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

}
