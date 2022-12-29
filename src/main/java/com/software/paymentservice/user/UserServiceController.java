package com.software.paymentservice.user;

import com.software.paymentservice.account.AccountController;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserServiceController {
    AccountController accountController;

    public UserServiceController(AccountController accountController) {
        this.accountController = accountController;
    }

    @RequestMapping(value = "/showCompleteService", method = RequestMethod.GET)
    public String showCompleteService() {
        return accountController.userController.showCompleteService();
    }


    @RequestMapping(value = "/showPendingRequest", method = RequestMethod.GET)
    public String showPendingRequest() {
        return accountController.userController.showPendingRequest();
    }

    @RequestMapping(value = "/showAcceptedService", method = RequestMethod.GET)
    public String showAcceptedService() {
        return accountController.userController.showAcceptedService();
    }

    @RequestMapping(value = "/showRejectedRequest", method = RequestMethod.GET)
    public String showRejectedRequest() {
        return accountController.userController.showRejectedRequest();
    }

    @RequestMapping(value = "/addToWallet", method = RequestMethod.POST)
    public String addMoneyToWallet(@RequestParam("amount") int amount) {
        return accountController.userController.addMoneyToWallet(amount);
    }

    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    public String refund(@RequestParam("id") int id) {
        return accountController.userController.refund(id);
    }

    @RequestMapping(value = "/showDiscounts", method = RequestMethod.GET)
    public String showDiscounts() {
        return accountController.userController.showDiscounts();

    }


}
