package com.software.paymentservice.provider;

import java.util.Scanner;

public class DonationProviderFactory implements ServiceProviderFactory {
    @Override
    public ServiceProvider create(int ID) {
        if (ID == 1) {
            return new CancerHospital();
        } else if (ID == 2) {
            return new Schools();
        } else if (ID == 3) {
            return new NGOs();
        }
        return null;
    }
}
