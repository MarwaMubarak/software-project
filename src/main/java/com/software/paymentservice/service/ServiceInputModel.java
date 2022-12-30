package com.software.paymentservice.service;

 public class ServiceInputModel {
    int paymentWayID;
    int serviceProviderID;
    double amount;
    String serviceName;
    String info;
    public ServiceInputModel()
    {

    }
    public ServiceInputModel(int paymentWayID, int serviceProviderID, double amount, String info,String serviceName) {
        this.paymentWayID = paymentWayID;
        this.serviceProviderID = serviceProviderID;
        this.amount = amount;
        this.serviceName=serviceName;
        if (info == null)
            this.info = " ";
        else
            this.info = info;
    }

    public ServiceInputModel(int paymentWayID, int serviceProviderID, double amount,String serviceName) {
        this.paymentWayID = paymentWayID;
        this.serviceProviderID = serviceProviderID;
        this.amount = amount;
        this.serviceName=serviceName;

        this.info = "";
    }

     public String getServiceName() {
         return serviceName;
     }

     public void setServiceName(String serviceName) {
         this.serviceName = serviceName;
     }

     public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
