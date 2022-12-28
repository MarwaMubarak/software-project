package com.software.paymentservice.user;

import java.util.*;

import com.software.paymentservice.Data.*;
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


    public void addCompeleteServices(Service service) {
        ServiceStatePair serviceStatePair = new ServiceStatePair(0, service);
        userModel.getCompleteServices().put(service.id, serviceStatePair);
        SavedData.getObj().setUsersCompleteService(userModel.getCompleteServices());
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


    public void showRefunds() {
        System.out.println("Press 1. Show Complete Services and make refund request");
        System.out.println("Press 2. Show Pending Services");
        System.out.println("Press 3. Show Accepted Services");
        System.out.println("Press 4. Show Rejected Services");
        int option = new Scanner(System.in).nextInt();
        int empty = 0;
        if (option == 1) {
            for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
                if (current.getValue().getState() == 0) {
                    System.out.println("ID:" + current.getKey() + "\t Service Name: " + current.getValue().service.getName());
                    empty++;
                }

            }
            if (empty != 0) {


                while (true) {
                    System.out.println("Enter service's ID : ");
                    int id = new Scanner(System.in).nextInt();
                    String success1 = AccountController.userController.refund(id);
                    userModel.getCompleteServices().get(id).setState(2);
                    if (success1 == "")
                        break;
                }
            } else {
                System.out.println("Empty..");
            }

        } else if (option == 2) {
            for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
                if (current.getValue().getState() == 2) {
                    System.out.println("ID:" + current.getKey() + "\t Service Name: " + current.getValue().service.getName());
                    empty++;
                }
            }
            if (empty == 0)
                System.out.println("Empty..");


        } else if (option == 3) {
            for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
                if (current.getValue().getState() == 1) {
                    System.out.println("ID:" + current.getKey() + "\t Service Name: " + current.getValue().service.getName());
                    empty++;
                }
            }
            if (empty == 0)
                System.out.println("Empty..");

        } else if (option == 4) {
            for (Map.Entry<Integer, ServiceStatePair> current : userModel.getCompleteServices().entrySet()) {
                if (current.getValue().getState() == -1) {
                    System.out.println("ID:" + current.getKey() + "\t Service Name: " + current.getValue().service.getName());
                    empty++;
                }
            }
            if (empty == 0)
                System.out.println("Empty..");
        }

    }

    public String refund(Integer ID) {
        if (!userModel.getCompleteServices().containsKey(ID)) {
            return "Invalid service !";
        }
        SavedData.getObj().getRefundService().put(ID, AccountController.userController);
        userModel.getCompleteServices().get(ID).setState(2);
        return "Your request is pending... ";
    }

    public void addMoneyToWallet() {
        System.out.println("Enter the amount you want to add: ");
        int amount = new Scanner(System.in).nextInt();
        if (userModel.getMyCrditCard().getBalance() >= amount) {
            userModel.getMyCrditCard().spend(amount);
            userModel.getMyWallet().add(amount);
            System.out.println("Done Successfully..");

        } else
            System.out.println("There is not money..");
    }

    public void showDiscounts() {
        int noDiscounts = 0;
        for (Map.Entry<String, Service> service : SavedData.getObj().services.entrySet()) {
            System.out.println(service.getKey() + ": " + service.getValue().getDiscounts() * 100 + "%");
            if (service.getValue().getDiscounts() != 0.0)
                noDiscounts++;
        }
        if (noDiscounts == 0)
            System.out.println("There is no discounts..");

    }
}
