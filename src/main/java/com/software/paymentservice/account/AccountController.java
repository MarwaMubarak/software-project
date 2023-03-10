package com.software.paymentservice.account;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.response.Response;
import com.software.paymentservice.user.UserController;
import com.software.paymentservice.user.UserModel;
import org.springframework.stereotype.Service;

@Service
public class AccountController {

    private static UserController userController;
    private AccountModel accountModel;
    private SavedData saveData;

    public static UserController getUserController() {
        return userController;
    }

    public static void setUserController(UserController userController) {
        AccountController.userController = userController;
    }

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

    public Response login(String email, String password) {
        if (saveData.getUserData().containsKey(email) && saveData.getUserData().get(email).getUserModel().getPassword().equals(password)) {
            userController = saveData.getUserData().get(email);
            return new Response("login successfully", userController.getUserModel());
        } else return new Response("failed to login", new UserModel());
    }

    public Response signUp(String userName, String email, String password) {
        if (!saveData.getUserData().containsKey(email) && !saveData.getUserData().containsKey(userName)) {
            UserController userController = new UserController(email, userName, password);
            saveData.getUserData().put(email, userController);
            saveData.getUserData().put(userName, userController);
            return new Response("Sign up Successfully", "");
        } else return new Response("Sign up Failed", "");
    }
}
