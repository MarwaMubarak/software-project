package com.software.paymentservice.Screen;

import java.util.ArrayList;
import java.util.Scanner;

import com.software.paymentservice.Data.*;

import com.software.paymentservice.admin.Admin;
import com.software.paymentservice.service.Search;
import com.software.paymentservice.user.Account;

public class UI {
    static Scanner cin = new Scanner(System.in);

    public static void appSteps() {
        while (true) {
            UI.home();
        }
    }

    public static void home() {
        System.out.println("Press 1. User");
        System.out.println("Press 2. Admin");
        int userOrAdmin = cin.nextInt();
        System.out.println("----------------------------------------------------------");

        while (userOrAdmin != 1 && userOrAdmin != 2) {
            System.out.println("Invalid Option!!");
            UI.home();

        }
        System.out.println("----------------------------------------------------------");
        if (userOrAdmin == 1)
            userSteps();
        else if (userOrAdmin == 2)
            adminSteps();
    }


    public static void userSteps() {
        System.out.println("Press 1. to Log In");
        System.out.println("Press 2. to Sign Up");
        int option = cin.nextInt();
        System.out.println("----------------------------------------------------------");
        while (option != 1 && option != 2) {
            System.out.println("Invalid Option!!");
            userSteps();
        }
        System.out.println("----------------------------------------------------------");
        if (option == 1) {
            loginSteps();
            System.out.println("----------------------------------------------------------");
            signedinUser();
            System.out.println("----------------------------------------------------------");


        } else if (option == 2) {
            signupSteps();
            System.out.println("----------------------------------------------------------");
            loginSteps();
            System.out.println("----------------------------------------------------------");
            signedinUser();
            System.out.println("----------------------------------------------------------");

        }

    }

    public static void loginSteps() {
        Invoker invoker = new Invoker();
        boolean success = false;
        while (!success) {
            System.out.println("Enter your Email:");
            String email_userName = cin.next();
            System.out.println("Enter your Password:");
            String password = cin.next();

            Account account = new Account(email_userName, email_userName, password);
            invoker.setCommand(new Login(account));
            success = invoker.doAction();
            if (!success) System.out.println(" Eamil or Password not correct!, Please try again..");
            System.out.println("----------------------------------------------------------");

        }
    }

    public static void signupSteps() {
        Invoker invoker = new Invoker();
        boolean success = false;
        while (!success) {
            System.out.println("Enter your Userame:");
            String username = cin.next();
            System.out.println("Enter your Email:");
            String email = cin.next();
            System.out.println("Enter your Password:");
            String password = cin.next();
            Account account = new Account(username, email, password);
            invoker.setCommand(new Register(account));
            success = invoker.doAction();
            if (!success) System.out.println(" eamil or userName are used!, please try again");
            System.out.println("----------------------------------------------------------");
        }
    }

    public static void signedinUser() {
        while (true) {
            System.out.println("Name: " + Account.user.userName + "\nBalance: " + Account.user.getMyWallet().getBalance() + "\n");
            System.out.println("----------------------------------------------------------");

            UI.userOptions();
            int userChoice = cin.nextInt();

            if (userChoice == 1) {
                servicesOptions();
                while (true) {
                    System.out.println("Enter Service Name as typed:");
                    String serviceName = new Scanner(System.in).next();
                    System.out.println("----------------------------------------------------------");

                    ArrayList<NameServicePair> list = Search.search(serviceName);
                    if (list.size() == 0) {
                        System.out.println("This service is not available!");
                    } else {
                        SavedData.getObj().services.get(list.get(0).name).serve();
                        break;
                    }
                }

            } else if (userChoice == 2) {
                while (true) {
                    System.out.println("search about the service [Enter the name of service]");
                    String serviceName = new Scanner(System.in).next();
                    ArrayList<NameServicePair> list = Search.search(serviceName);
                    if (list.size() == 0) {
                        System.out.println("This service not available!");
                    } else if (list.size() == 1) {
                        System.out.println("Your service is: " + list.get(0).name);
                        System.out.println("----------------------------------------------------------");
                        SavedData.getObj().services.get(list.get(0).name).serve();
                        break;
                    } else {
                        System.out.println("Enter The Name of The Service: ");
                        Search.showSearchResult(list);
                        serviceName = new Scanner(System.in).next();
                        SavedData.getObj().services.get(serviceName).serve();
                        break;
                    }
                    System.out.println("----------------------------------------------------------");

                }

            } else if (userChoice == 3) Account.user.showRefunds();
            else if (userChoice == 4) Account.user.showDiscounts();
            else if (userChoice == 5) {
                Account.user.addMoneyToWallet();
            } else if (userChoice == 6) appSteps();
            else
                System.out.println("Invalid Input, You should choose from user's options!");

        }

    }


    static void adminSteps() {
        while (true) {
            UI.adminOptions();
            int adminChoice = cin.nextInt();
            if (adminChoice == 4) appSteps();
            else if (adminChoice == 2) {
                Admin admin = new Admin();
                admin.showRefund();
            } else if (adminChoice == 1) {
                Admin admin = new Admin();
                admin.addDiscount();
            } else if (adminChoice == 3) {
                Admin admin = new Admin();
                admin.cashAvaliablity();
            } else
                System.out.println("Invalid input, You should choose from admin's options! ");
        }

    }

    public static void userOptions() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Press 1. show all services");
        System.out.println("Press 2. searchService");
        System.out.println("Press 3. refund");
        System.out.println("Press 4. showDiscounts");
        System.out.println("Press 5. addFundsToWallet");
        System.out.println("press 6. To exit");
        System.out.println("----------------------------------------------------------");

    }

    public static void adminOptions() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Press 1. addDiscount");
        System.out.println("Press 2. showRefund");
        System.out.println("Press 3. CashAvaliablity");
        System.out.println("press 4. To exit");
        System.out.println("----------------------------------------------------------");

    }

    public static void servicesOptions() {
        System.out.println("----------------------------------------------------------");

        System.out.println("MobileRecharge");
        System.out.println("InternetPayment");
        System.out.println("Landline");
        System.out.println("Donation");
        System.out.println("----------------------------------------------------------");


    }


}
