package com.software.paymentservice.provider;

import java.util.Scanner;

public class LandlineProviderFactory implements ServiceProviderFactory {
    @Override
    public ServiceProvider create(int ID) {

        if (ID == 1)
            return new MonthlyReceiptLandline();
        else if (ID == 2)
            return new QuarterReceiptLandline();

        return null;
    }
}
