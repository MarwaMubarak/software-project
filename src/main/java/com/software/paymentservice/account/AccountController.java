package com.software.paymentservice.account;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.user.UserController;
import org.springframework.stereotype.Service;

import java.lang.String;

@Service
public class AccountController {

    private AccountModel accountModel;
    SavedData saveData;
    public static UserController userController;

    public AccountModel getAccountModel() {
        return accountModel;
    }

    public AccountController() {
        saveData = SavedData.getObj();
    }

    public AccountController(String userName, String userEmail, String password) {
        saveData = SavedData.getObj();
        accountModel = new AccountModel(userEmail, userName, password);
    }


    public String login(String email, String password) {
        if (saveData.getUserData().containsKey(email)) {
            userController = saveData.getUserData().get(email);
            if (userController.getUserModel().getPassword().equals(password))
                return "Login Successfully";
            else
                return "Login Failed";
        } else return "Login Failed";
    }

    public String signUp(String userName, String email, String password) {
        if (!saveData.getUserData().containsKey(email) && !saveData.getUserData().containsKey(userName)) {
            UserController userController = new UserController(email, userName, password);
            saveData.getUserData().put(email, userController);
            saveData.getUserData().put(userName, userController);
            return "Sign up Successfully";
        } else return "Sign up Failed";
    }
}
