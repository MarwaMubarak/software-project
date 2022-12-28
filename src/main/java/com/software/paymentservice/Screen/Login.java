package com.software.paymentservice.Screen;

import com.software.paymentservice.user.AccountController;

public class Login implements Command {
    AccountController accountController;

    public Login(AccountController accountController) {
        this.accountController = accountController;
    }

    public String excute() {
        return (accountController.login(accountController.getAccountModel().getUserName(), accountController.getAccountModel().getPassword()));
    }

}
