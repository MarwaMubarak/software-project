package com.software.paymentservice.provider;

import java.util.Scanner;

public class InternetProviderFactory implements ServiceProviderFactory {

    @Override
    public ServiceProvider create(int ID) {

        if (ID == 1) {
            return new Etisalat();
        } else if (ID == 2) {
            return new Vodafone();
        } else if (ID == 3) {
            return new Orange();
        } else if (ID == 4) {
            return new WE();
        }
        return null;
    }

}
