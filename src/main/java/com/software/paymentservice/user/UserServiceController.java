package com.software.paymentservice.user;

import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.response.Response;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserServiceController {
    AccountController accountController;

    public UserServiceController(AccountController accountController) {
        this.accountController = accountController;
    }

    @RequestMapping(value = "/showCompleteService", method = RequestMethod.GET)
    public Response showCompleteService() {
        return accountController.userController.showCompleteService();
    }


    @RequestMapping(value = "/showPendingRequest", method = RequestMethod.GET)
    public Response showPendingRequest() {
        return accountController.userController.showPendingRequest();
    }

    @RequestMapping(value = "/showAcceptedService", method = RequestMethod.GET)
    public Response showAcceptedService() {
        return accountController.userController.showAcceptedService();
    }

    @RequestMapping(value = "/showRejectedRequest", method = RequestMethod.GET)
    public Response showRejectedRequest() {
        return accountController.userController.showRejectedRequest();
    }

    @RequestMapping(value = "/addToWallet", method = RequestMethod.POST)
    public Response addMoneyToWallet(@RequestParam("amount") int amount) {
        return accountController.userController.addMoneyToWallet(amount);
    }

    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    public Response refund(@RequestParam("id") int id) {
        return accountController.userController.refund(id);
    }

    @RequestMapping(value = "/showDiscounts", method = RequestMethod.GET)
    public Response showDiscounts() {
        return accountController.userController.showDiscounts();

    }


}
