package com.software.paymentservice.service;

public class ServiceFactory {

    public Service create(String serviceType) {
        if (serviceType.equals("MobileRecharge"))
            return new MobileRechargeService();
        else if (serviceType.equals("InternetPayment"))
            return new InternetPaymentService();
        else if (serviceType.equals("Donation"))
            return new DonationService();
        else if (serviceType.equals("Landline"))
            return new LandlineService();
        else
            return null;
    }

}
