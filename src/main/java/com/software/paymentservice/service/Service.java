
package com.software.paymentservice.service;

import com.software.paymentservice.payment.*;
import com.software.paymentservice.provider.FactoryOfServiceProviderFactory;
import com.software.paymentservice.provider.ServiceProvider;
import com.software.paymentservice.provider.ServiceProviderFactory;
import com.software.paymentservice.account.AccountController;
import org.springframework.stereotype.Component;

public abstract class Service {
    static public int id;
    public double cost;
    Payment payment = new CreditPayment();
    Double discount = 0.0;
    ServiceProvider provider;
    boolean cash = false;


    public Service() {
        id = 1;
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

    public String serve(ServiceInputModel serviceInputModel) {
        setPayment(serviceInputModel.getPaymentWayID());
        setProvider(serviceInputModel.getServiceProviderID());
        discount = getDiscounts();
        setCost(payment.pay(discount, serviceInputModel.amount));
        if (cost != -1) {
            AccountController.userController.addCompeleteServices(this);
            provider.setInfo(serviceInputModel.amount, serviceInputModel.getInfo());
            setId(id + 1);
            return getInfo();
        } else
            setCost(0);
        return "Service not Complete";
    }

    abstract public String getName();

    public String getInfo() {
        String S = "";
        S += ("----------------------------------------------------------\n");
        S += ("Service Name: " + this.getName() + '\n');
        S += ("Service Id: " + id + '\n');
        S += ("Payment Way: " + payment.getName() + '\n');
        S += ("Service Provider: " + provider.getName() + '\n');
        S += ("Discounts: " + getDiscounts() * 100 + "%" + '\n');
        S += ("Payment Taxes: " + payment.getTaxes() + "LE" + '\n');
        S += ("Service Total Cost: " + cost + "LE" + '\n');
        S += ("----------------------------------------------------------" + '\n');
        return S;
    }


}
