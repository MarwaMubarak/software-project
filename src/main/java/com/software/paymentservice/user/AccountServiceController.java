package com.software.paymentservice.user;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountServiceController {
    private AccountController accountController;

    public AccountServiceController(AccountController accountController) {
        this.accountController = accountController;
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody AccountModel accountModel) {
        return accountController.login(accountModel.getUserEmail(),accountModel.getPassword());
    }

    @PostMapping(value = "/signUp")
    public String signUp(@RequestBody AccountModel accountModel) {
        return accountController.signUp(accountModel.getUserName(), accountModel.getUserEmail(), accountModel.getPassword());
    }
}
