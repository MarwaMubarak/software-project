package com.software.paymentservice.admin;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.Data.ServiceStatePair;
import com.software.paymentservice.Screen.UI;
import com.software.paymentservice.discount.Discount;
import com.software.paymentservice.discount.DiscountFactory;
import com.software.paymentservice.user.UserController;
import com.software.paymentservice.user.UserModel;

public class Admin {
    Discount discount;

    public void addDiscount() {
        DiscountFactory discountFactory = new DiscountFactory();
        discount = discountFactory.create();
        discount.addDiscount();
    }

    public void showRefund() {
        Scanner cin = new Scanner(System.in);
        SavedData obj = SavedData.getObj();
        for (Entry<Integer, UserController> currentRefund : SavedData.getObj().getRefundService().entrySet()) {
            System.out.print(currentRefund.getKey() + " ");
            int Id = currentRefund.getKey();
            UserController userController = currentRefund.getValue();
            Map<Integer, ServiceStatePair> current = obj.usersCompleteService.get(userController.getUserModel().getEmail());
            System.out.println(current.get(Id).service.getName());

        }
        System.out.println("Choose service ");
        int id = cin.nextInt();
        System.out.println("1. Accept  or 2. reject ");
        int op = cin.nextInt();
        while (op != 1 && op != 2) {
            System.out.println("1. Accept  or 2. reject ");
            op = cin.nextInt();

        }
        UserController userController = obj.getRefundService().get(id);
        if (op == 1) {
            Map<Integer, ServiceStatePair> current = obj.usersCompleteService.get(userController.getUserModel().getEmail());
            userController.getUserModel().getMyWallet().add(current.get(id).service.getCost());
            obj.usersCompleteService.get(userController.getUserModel().getEmail()).get(id).setState(1);
        } else {

            obj.usersCompleteService.get(userController.getUserModel().getEmail()).get(id).setState(-1);

        }
        obj.getRefundService().remove(id);
    }

    public void cashAvaliablity() {
        System.out.println("Enter Service Name to set Cash avaliablity: ");
        UI.servicesOptions();
        String serviceName = new Scanner(System.in).next();
        System.out.println("Enter true or false");
        boolean visible = new Scanner(System.in).nextBoolean();
        SavedData.getObj().services.get(serviceName).setCash(visible);

    }
}
