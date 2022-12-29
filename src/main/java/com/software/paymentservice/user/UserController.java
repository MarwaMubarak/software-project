package com.software.paymentservice.user;

import java.util.*;

import com.software.paymentservice.Data.*;
import com.software.paymentservice.account.AccountController;
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


    public String showCompleteService() {
        int empty = 0;
        String s = "";
        Vector<String> vs = new Vector<>();
        for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
            if (current.getValue().getState() == 0) {
                s += "ID:" + current.getKey() + "\t Service Name: " + current.getValue().service.getName() + "\n";
                vs.add("ID:" + current.getKey() + "\t Service Name: " + current.getValue().service.getName() + "\n");
                empty++;
            }
        }
        if (empty == 0) {
            return ("Empty..");
        }
        return s;
    }

    public String showPendingRequest() {
        int empty = 0;
        String s = "";
        for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
            if (current.getValue().getState() == 2) {
                s += ("ID:" + current.getKey() + "\t Service Name: " + current.getValue().service.getName() + '\n');
                empty++;
            }
        }
        if (empty == 0)
            return ("Empty..");
        return s;
    }

    public String showAcceptedService() {
        int empty = 0;
        String s = "";
        for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
            if (current.getValue().getState() == 1) {
                s += ("ID:" + current.getKey() + "\t Service Name: " + current.getValue().service.getName() + '\n');
                empty++;
            }
        }
        if (empty == 0)
            return ("Empty..");
        return s;

    }

    public String showRejectedRequest() {
        int empty = 0;
        String s = "";
        for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
            if (current.getValue().getState() == -1) {
                s += ("ID:" + current.getKey() + "\t Service Name: " + current.getValue().service.getName() + '\n');
                empty++;
            }
        }
        if (empty == 0)
            return ("Empty..");
        return s;
    }


    public String refund(Integer ID) {
        if (!userModel.getCompleteServices().containsKey(ID)) {
            return "Invalid service id !";
        }
        SavedData.getObj().getRefundService().put(ID, AccountController.userController);
        userModel.getCompleteServices().get(ID).setState(2);
        return "Your request is pending... ";
    }

    public void addCompeleteServices(Service service) {
        ServiceStatePair serviceStatePair = new ServiceStatePair(0, service);
        userModel.getCompleteServices().put(service.id, serviceStatePair);
        SavedData.getObj().setUsersCompleteService(userModel.getCompleteServices());

    }

    public String addMoneyToWallet(Integer amount) {
        if (userModel.getMyCreditCard().getBalance() >= amount) {
            userModel.getMyCreditCard().spend(amount);
            userModel.getMyWallet().add(amount);
            String s= SavedData.getObj().getWalletTransactions().get(userModel.getEmail());
            s+=userModel.getEmail()+" Added "+amount+"\n";
            SavedData.getObj().getWalletTransactions().put(userModel.getEmail(),s);
            return ("Done Successfully..");

        } else
            return ("There is not money..");
    }

    public String showDiscounts() {
        int noDiscounts = 0;
        String s = "";
        for (Map.Entry<String, Service> service : SavedData.getObj().services.entrySet()) {
            s += (service.getKey() + ": " + service.getValue().getDiscounts() * 100 + "%\n");
            if (service.getValue().getDiscounts() != 0.0)
                noDiscounts++;
        }
        if (noDiscounts == 0)
            return ("There is no discounts..");
        return s;

    }
}
