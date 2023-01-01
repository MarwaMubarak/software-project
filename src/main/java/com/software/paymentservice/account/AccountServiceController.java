package com.software.paymentservice.account;

import com.software.paymentservice.response.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountServiceController {

    private AccountController accountController;

    public AccountServiceController(AccountController accountController) {
        this.accountController = accountController;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Response login(@RequestBody AccountModel accountModel) {
        return accountController.login(accountModel.getUserEmail(), accountModel.getPassword());
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Response signUp(@RequestBody AccountModel accountModel) {
        return accountController.signUp(accountModel.getUserName(), accountModel.getUserEmail(), accountModel.getPassword());
    }

}
