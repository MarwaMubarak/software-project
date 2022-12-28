package com.software.paymentservice.user;

import com.software.paymentservice.Data.ServiceStatePair;

import java.util.HashMap;
import java.util.Map;

public class UserModel {
    private String email;
    private String userName;
    private String passwrod;
    private CreditCard myCrditCard;
    private Wallet myWallet;
    private Map<Integer, ServiceStatePair> completeServices;

    public UserModel(String email, String userName, String passwrod) {
        this.email = email;
        this.userName = userName;
        this.passwrod = passwrod;
        completeServices = new HashMap<Integer, ServiceStatePair>();
        myWallet = new Wallet();
        myCrditCard = new CreditCard();
        myCrditCard.add(1000);
    }


    public void setCompleteServices(Map<Integer, ServiceStatePair> completeServices) {
        this.completeServices = completeServices;
    }

    public Map<Integer, ServiceStatePair> getCompleteServices() {
        return completeServices;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public CreditCard getMyCrditCard() {
        return myCrditCard;
    }

    public Wallet getMyWallet() {
        return myWallet;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public void setMyCrditCard(CreditCard myCrditCard) {
        this.myCrditCard = myCrditCard;
    }

    public void setMyWallet(Wallet myWallet) {
        this.myWallet = myWallet;
    }
}
