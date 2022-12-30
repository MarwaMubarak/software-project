package com.software.paymentservice.user;

import java.util.*;

import com.software.paymentservice.Data.*;
import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.response.Response;
import com.software.paymentservice.service.*;


public class UserController {

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    private UserModel userModel;


    public UserController(String email, String userName, String password) {
        userModel = new UserModel(email, userName, password);
    }


    public Response showCompleteService() {
        int empty = 0;
        ArrayList<String>s=new ArrayList<>();
        for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
            //if (current.getValue().getState() == 0) {
                s.add("ID:" + current.getKey() + "   Service Name: " + current.getValue().service.getName());
                empty++;
           // }
        }
        if (empty == 0) {
            return (new Response("Empty..",""));
        }
        return new Response("Done..",s);
    }

    public Response showPendingRequest() {
        int empty = 0;
        ArrayList<String>s=new ArrayList<>();
        for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
            if (current.getValue().getState() == 2) {
                s.add ("ID:" + current.getKey() + "   Service Name: " + current.getValue().service.getName());
                empty++;
            }
        }
        if (empty == 0)
            return new Response("Empty..","");
        return new Response("Done..",s);
    }

    public Response showAcceptedService() {
        int empty = 0;
        ArrayList<String>s=new ArrayList<>();
        for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
            if (current.getValue().getState() == 1) {
                s .add ("ID:" + current.getKey() + "    Service Name: " + current.getValue().service.getName());
                empty++;
            }
        }
        if (empty == 0)
            return new Response("Empty..","");
        return new Response("Done..",s);

    }

    public Response showRejectedRequest() {
        int empty = 0;
        ArrayList<String>s=new ArrayList<>();
        for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
            if (current.getValue().getState() == -1) {
                s.add ("ID:" + current.getKey() + "   Service Name: " + current.getValue().service.getName() );
                empty++;
            }
        }
        if (empty == 0)
            return new Response("Empty..","");
        return new Response("Done..",s);
    }


    public Response refund(Integer ID) {
        if (!userModel.getCompleteServices().containsKey(ID)) {
            return new Response( "Invalid service id !","");
        }
        SavedData.getObj().getRefundService().put(ID, AccountController.getUserController());
        userModel.getCompleteServices().get(ID).setState(2);
        if( SavedData.getObj().getRefundTransactions().containsKey(userModel.getEmail()))
            SavedData.getObj().getRefundTransactions().get(userModel.getEmail()).add("service ID: "+ID+" service name"+userModel.getCompleteServices().get(ID).service.getName());
        else{
            ArrayList<String>arr=new ArrayList<>();
            arr.add("service ID: "+ID+" service name: "+userModel.getCompleteServices().get(ID).service.getName());
            SavedData.getObj().getRefundTransactions().put(userModel.getEmail(),arr);


        }
        return new Response("Your request is pending... ","");
    }

    public void addCompeleteServices(Service service) {
        ServiceStatePair serviceStatePair = new ServiceStatePair(0, service);
        userModel.getCompleteServices().put(service.id, serviceStatePair);
        SavedData.getObj().setUsersCompleteService(userModel.getCompleteServices());

    }

    public Response addMoneyToWallet(Integer amount) {
        if (userModel.getMyCreditCard().getBalance() >= amount) {
            userModel.getMyCreditCard().spend(amount);
            userModel.getMyWallet().add(amount);
            if( SavedData.getObj().getWalletTransactions().containsKey(userModel.getEmail())) {
                SavedData.getObj().getWalletTransactions().get(userModel.getEmail()).add(userModel.getEmail()+" Added "+amount);
            }else{
                ArrayList<String>arr=new ArrayList<>();
                arr.add(userModel.getEmail()+" Added "+amount);
                SavedData.getObj().getWalletTransactions().put(userModel.getEmail(),arr);
            }

            return new Response("Done Successfully..","");

        } else
            return new Response("There is not money..","");
    }

    public Response showDiscounts() {
        int noDiscounts = 0;
        ArrayList<String>s=new ArrayList<>();
        for (Map.Entry<String, Service> service : SavedData.getObj().getServices().entrySet()) {
            s.add (service.getKey() + ": " + service.getValue().getDiscounts() * 100 + "%");
            if (service.getValue().getDiscounts() != 0.0)
                noDiscounts++;
        }
        if (noDiscounts == 0)
            return new Response("There is no discounts..","");
        return new Response("Done..",s);

    }
}
