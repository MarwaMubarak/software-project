package com.software.paymentservice.admin;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.Data.ServiceStatePair;
import com.software.paymentservice.Screen.UI;
import com.software.paymentservice.discount.Discount;
import com.software.paymentservice.discount.DiscountFactory;
import com.software.paymentservice.response.Response;
import com.software.paymentservice.user.UserController;
import org.springframework.stereotype.Service;

@Service
public class AdminController {

    public Response addDiscount(String choice,String serviceName,int amount) {
        Discount discount;
        DiscountFactory discountFactory = new DiscountFactory();
        discount = discountFactory.create(choice);
        discount.addDiscount(serviceName,amount);
        return new Response("Added Successfully..","");
    }

    public Response refundResponse(int id, int op) {
        SavedData obj = SavedData.getObj();
        if (!obj.getRefundService().containsKey(id)) return new Response("Wrong service ID","");
        UserController userController = obj.getRefundService().get(id);
        if (op == 1) {
            Map<Integer, ServiceStatePair> current = obj.usersCompleteService.get(userController.getUserModel().getEmail());
            userController.getUserModel().getMyWallet().add(current.get(id).service.getCost());
            obj.usersCompleteService.get(userController.getUserModel().getEmail()).get(id).setState(1);
            obj.getRefundService().remove(id);
            return new Response("Refund accepted","");
        } else {
            obj.usersCompleteService.get(userController.getUserModel().getEmail()).get(id).setState(-1);
            obj.getRefundService().remove(id);
            return new Response("Refund rejected","");
        }
    }

    public Response showRefund() {
        ArrayList<String> s =new ArrayList<>();
        SavedData obj = SavedData.getObj();
        for (Entry<Integer, UserController> currentRefund : SavedData.getObj().getRefundService().entrySet()) {
            String temp="";
            temp+= ("ID: "+currentRefund.getKey() + " ");
            int Id = currentRefund.getKey();
            UserController userController = currentRefund.getValue();
            Map<Integer, ServiceStatePair> current = obj.usersCompleteService.get(userController.getUserModel().getEmail());
            temp += ("service name: "+current.get(Id).service.getName() );
            s.add(temp);
        }
        if (s.isEmpty())
            return new Response("Empty",s);
        else
            return new Response("Done..",s);
    }

    public Response cashAvailability(String serviceName,boolean visible ) {
        SavedData.getObj().services.get(serviceName).setCash(visible);
        return new Response("cashAvailability done","");
    }
    public Response showPaymentTransaction() {
       ArrayList< String> s = new ArrayList<>();
        for (Entry<String, Map<Integer, ServiceStatePair>> bigMap : SavedData.getObj().getUsersCompleteService().entrySet()) {
            for (Entry<Integer, ServiceStatePair> serviceStatePair : bigMap.getValue().entrySet())
                s.add( "Service: " + serviceStatePair.getValue().service.getName() + ", with cost: " + serviceStatePair.getValue().service.getCost());
        }
        if (s.isEmpty())
            return new Response("Empty","");
        else
            return new Response("Done..",s);
    }

    public Response showAddToWalletTransaction() {

        ArrayList<String>s=new ArrayList<>();
        for (Entry<String, ArrayList<String>> entry : SavedData.getObj().getWalletTransactions().entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                s.add( entry.getValue().get(i));
            }

        }
        if (s.isEmpty())
            return new Response( "Empty","");
        else
            return new Response("Done",s);

    }

    public Response showRefundTransaction() {

        ArrayList<String>s=new ArrayList<>();
        for (Entry<String, ArrayList<String>> currentRefund : SavedData.getObj().getRefundTransactions().entrySet()) {
            for (int i = 0; i < currentRefund.getValue().size(); i++) {
                s.add(currentRefund.getValue().get(i));
            }

        }
        if (s.isEmpty())
            return new Response("Empty","");
        else
            return new Response("Done",s);
    }

}
