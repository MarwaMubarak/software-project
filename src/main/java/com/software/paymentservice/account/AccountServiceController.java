package com.software.paymentservice.account;

import org.springframework.web.bind.annotation.*;


@RestController
public class AccountServiceController {
    private AccountController accountController;

    public AccountServiceController(AccountController accountController) {
        this.accountController = accountController;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody AccountModel accountModel) {
        return accountController.login(accountModel.getUserEmail(),accountModel.getPassword());
    }

    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    public String signUp(@RequestBody AccountModel accountModel) {
        return accountController.signUp(accountModel.getUserName(), accountModel.getUserEmail(), accountModel.getPassword());
    }

}
