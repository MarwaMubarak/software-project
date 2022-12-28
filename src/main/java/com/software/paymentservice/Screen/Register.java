package com.software.paymentservice.Screen;

import com.software.paymentservice.user.*;

public class Register implements Command {
    AccountController accountController;

    public Register(AccountController accountController) {
        this.accountController = accountController;
    }

    public String excute() {
        return (this.accountController.signUp(accountController.getAccountModel().getUserName(), accountController.getAccountModel().getUserEmail(), accountController.getAccountModel().getPassword()));
    }

}
