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
import org.springframework.stereotype.Service;

@Service
public class AdminController {

    public void addDiscount() {
        Discount discount;
        DiscountFactory discountFactory = new DiscountFactory();
        discount = discountFactory.create();
        discount.addDiscount();
    }

    public String refundResponse(int id, int op) {
        SavedData obj = SavedData.getObj();
        if (!obj.getRefundService().containsKey(id)) return "Wrong service ID";
        UserController userController = obj.getRefundService().get(id);
        if (op == 1) {
            Map<Integer, ServiceStatePair> current = obj.usersCompleteService.get(userController.getUserModel().getEmail());
            userController.getUserModel().getMyWallet().add(current.get(id).service.getCost());
            obj.usersCompleteService.get(userController.getUserModel().getEmail()).get(id).setState(1);
            obj.getRefundService().remove(id);
            return "Refund accepted";
        } else {
            obj.usersCompleteService.get(userController.getUserModel().getEmail()).get(id).setState(-1);
            obj.getRefundService().remove(id);
            return "Refund rejected";
        }
    }

    public String showRefund() {
        String s = "";
        SavedData obj = SavedData.getObj();
        for (Entry<Integer, UserController> currentRefund : SavedData.getObj().getRefundService().entrySet()) {
            s += (currentRefund.getKey() + " ");
            int Id = currentRefund.getKey();
            UserController userController = currentRefund.getValue();
            Map<Integer, ServiceStatePair> current = obj.usersCompleteService.get(userController.getUserModel().getEmail());
            s += (current.get(Id).service.getName() + '\n');
        }
        if (s.isEmpty())
            return "Empty";
        else
            return s;
    }

    public String cashAvailability(String serviceName,boolean visible ) {
        SavedData.getObj().services.get(serviceName).setCash(visible);
        return ("cashAvailability done");
    }
    public String showPaymentTransaction() {
        String s = "";
        for (Entry<String, Map<Integer, ServiceStatePair>> bigMap : SavedData.getObj().getUsersCompleteService().entrySet()) {
            for (Entry<Integer, ServiceStatePair> serviceStatePair : bigMap.getValue().entrySet())
                s += "Servcie: " + serviceStatePair.getValue().service.getName() + ", with cost: " + serviceStatePair.getValue().service.getCost() + '\n';
        }
        if (s.isEmpty())
            return "Empty";
        else
            return s;
    }

    public String showAddToWalletTransaction() {
        String s = "";
        for (Entry<String, String> entry : SavedData.getObj().getWalletTransactions().entrySet()) {
            s += entry.getValue();
        }
        if (s.isEmpty())
            return "Empty";
        else
            return s;

    }

    public String showRefundTransaction() {
        String s = "";
        for (Entry<Integer, UserController> currentRefund : SavedData.getObj().getRefundService().entrySet()) {
            s += "Service with ID:" + currentRefund.getKey() + ", with name " +
                    SavedData.getObj().getUsersCompleteService().get(currentRefund.getValue().getUserModel().getEmail()).get(currentRefund.getKey())
                            .service.getName() + "made by :" +
                    currentRefund.getValue().getUserModel().getUserName() + '\n';
        }
        if (s.isEmpty())
            return "Empty";
        else
            return s;
    }

}
