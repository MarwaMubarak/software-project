
package com.software.paymentservice.service;

import com.software.paymentservice.payment.*;
import com.software.paymentservice.provider.*;
import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.response.Response;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

public abstract class Service {
    static public int id;
    public double cost;
    Payment payment = new CreditPayment();
    Double discount = 0.0;
    ServiceProvider provider;
    boolean cash = false;


    public Service() {
        id = 0;
        cost = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCash(boolean cash) {
        this.cash = cash;
    }

    public boolean getCash() {
        return cash;
    }

    void setPayment(int ID) {
        PaymentFactory paymentFactory = new PaymentFactory();
        this.payment = paymentFactory.create(ID);

    }

    public Payment getPayment() {
        return payment;
    }

    public void setProvider(int ID) {
        FactoryOfServiceProviderFactory factoryOfServiceProviderFactory = new FactoryOfServiceProviderFactory();
        ServiceProviderFactory serviceProviderFactory = factoryOfServiceProviderFactory.create(getName());
        provider = serviceProviderFactory.create(ID);
    }

    public ServiceProvider getProvider() {
        return provider;
    }


    public void setDiscount(int discount) {
        this.discount = discount / 100.0;
    }

    public Double getDiscounts() {
        return discount;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public Response serve(ServiceInputModel serviceInputModel) {
        if(serviceInputModel.paymentWayID==3&& !getCash())
            return new Response("There is no cash","");
        setPayment(serviceInputModel.getPaymentWayID());
        setProvider(serviceInputModel.getServiceProviderID());
        discount = getDiscounts();
        setCost(payment.pay(discount, serviceInputModel.amount));
        if (cost != -1) {
            setId(id + 1);
            AccountController.userController.addCompeleteServices(this);
            provider.setInfo(serviceInputModel.amount, serviceInputModel.getInfo());
            return new Response("Done..",getInfo());
        } else
            setCost(0);
        return new Response("Service not Complete","");
    }

    abstract public String getName();

    public ArrayList<String> getInfo() {
        ArrayList<String>curr=new ArrayList<String>();
        curr.add("----------------------------------------------------------");
        curr.add("Service Name: " + this.getName() );
        curr.add("Service Id: " + id );
        curr.add("Payment Way: " + payment.getName() );
        curr.add("Service Provider: " + provider.getName() );
        curr.add("Discounts: " + getDiscounts() * 100 + "%" );
        curr.add("Payment Taxes: " + payment.getTaxes() + "LE" );
        curr.add("Service Total Cost: " + cost + "LE" );
        curr.add("----------------------------------------------------------" );
        return curr;
    }


}
