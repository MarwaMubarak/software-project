package com.software.paymentservice.service;

abstract public class ServiceInputModel {
    int paymentWayID;
    int serviceProviderID;
    double amount;

    String info;


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ServiceInputModel(int paymentWayID, int serviceProviderID, double amount, String info) {
        this.paymentWayID = paymentWayID;
        this.serviceProviderID = serviceProviderID;
        this.amount = amount;
//        if (info == null)
//            this.info = "122";
//        else
            this.info = info;
    }

    public ServiceInputModel(int paymentWayID, int serviceProviderID, double amount) {
        this.paymentWayID = paymentWayID;
        this.serviceProviderID = serviceProviderID;
        this.amount = amount;
        this.info = "";
    }

    public int getPaymentWayID() {
        return paymentWayID;
    }

    public void setPaymentWayID(int paymentWayID) {
        this.paymentWayID = paymentWayID;
    }

    public int getServiceProviderID() {
        return serviceProviderID;
    }

    public void setServiceProviderID(int serviceProviderID) {
        this.serviceProviderID = serviceProviderID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
