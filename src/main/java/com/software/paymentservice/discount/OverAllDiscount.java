package com.software.paymentservice.discount;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.service.DiscountDecorator;
import com.software.paymentservice.service.Service;

public class OverAllDiscount implements Discount {

    @Override
    public void addDiscount(String serviceName, int discount) {

        Iterator<Entry<String, Service>> it = SavedData.getObj().getServices().entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Service> service = (Entry<String, Service>) it.next();

            Service discountService = new DiscountDecorator(service.getValue());
            discountService.setDiscount(discount);
            SavedData.getObj().getServices().replace(service.getKey(), discountService);
        }
    }

}
