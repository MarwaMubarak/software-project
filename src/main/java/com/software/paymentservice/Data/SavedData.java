package com.software.paymentservice.Data;

import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.payment.CashPayment;
import com.software.paymentservice.payment.CreditPayment;
import com.software.paymentservice.payment.Payment;
import com.software.paymentservice.payment.WalletPayment;
import com.software.paymentservice.provider.ServiceProvider;
import com.software.paymentservice.user.*;

import java.util.*;

import com.software.paymentservice.service.*;

public class SavedData {

    private static SavedData savedData = null;
    public String baseUrl="http://localhost:8080";

    public Map<String, Map<Integer, ServiceStatePair>> usersCompleteService;
    public Map<String, Service> services;
    public Payment payment;
    public ServiceProvider serviceProvider;

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

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
        return usersCompleteService.get(AccountController.userController.getUserModel().getEmail());
    }

    public Map<String, Map<Integer, ServiceStatePair>> getUsersCompleteService() {
        return usersCompleteService;
    }

    public void setUsersCompleteService(Map<Integer, ServiceStatePair> userCompliete) {
        usersCompleteService.put(AccountController.userController.getUserModel().getEmail(), userCompliete);
    }
    public String getBaseUrl() {
        return baseUrl;
    }

}
