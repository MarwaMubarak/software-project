package com.software.paymentservice.discount;

import java.util.Scanner;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.Screen.UI;
import com.software.paymentservice.service.DiscountDecorator;
import com.software.paymentservice.service.Service;

public class SpecificDiscount implements Discount {

    @Override
    public void addDiscount(String serviceName,int discount) {

        Service discountService = new DiscountDecorator(SavedData.getObj().services.get(serviceName));
        discountService.setDiscount(discount);
        SavedData.getObj().services.put(serviceName, discountService);

    }

}
