package com.software.paymentservice.user;

import com.software.paymentservice.Data.ServiceStatePair;

import java.util.HashMap;
import java.util.Map;

public class UserModel {
    private String email;
    private String userName;
    private String password;
    private CreditCard myCreditCard;
    private Wallet myWallet;
    private Map<Integer, ServiceStatePair> completeServices;
    public UserModel() {

    }
    public UserModel(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        completeServices = new HashMap<Integer, ServiceStatePair>();
        myWallet = new Wallet();
        myCreditCard = new CreditCard();
        myCreditCard.add(1000);
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

    public String getPassword() {
        return password;
    }

    public CreditCard getMyCreditCard() {
        return myCreditCard;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMyCreditCard(CreditCard myCreditCard) {
        this.myCreditCard = myCreditCard;
    }

    public void setMyWallet(Wallet myWallet) {
        this.myWallet = myWallet;
    }
}
