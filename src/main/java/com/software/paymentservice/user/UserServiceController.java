package com.software.paymentservice.user;

import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {
    private AccountController accountController;

    public UserServiceController(AccountController accountController) {
        this.accountController = accountController;
    }

    @RequestMapping(value = "/showCompleteService", method = RequestMethod.GET)
    public Response showCompleteService() {
        return accountController.getUserController().showCompleteService();
    }


    @RequestMapping(value = "/showPendingRequest", method = RequestMethod.GET)
    public Response showPendingRequest() {
        return accountController.getUserController().showPendingRequest();
    }

    @RequestMapping(value = "/showAcceptedService", method = RequestMethod.GET)
    public Response showAcceptedService() {
        return accountController.getUserController().showAcceptedService();
    }

    @RequestMapping(value = "/showRejectedRequest", method = RequestMethod.GET)
    public Response showRejectedRequest() {
        return accountController.getUserController().showRejectedRequest();
    }

    @RequestMapping(value = "/addToWallet", method = RequestMethod.POST)
    public Response addMoneyToWallet(@RequestParam("amount") int amount) {
        return accountController.getUserController().addMoneyToWallet(amount);
    }

    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    public Response refund(@RequestParam("id") int id) {
        return accountController.getUserController().refund(id);
    }

    @RequestMapping(value = "/showDiscounts", method = RequestMethod.GET)
    public Response showDiscounts() {
        return accountController.getUserController().showDiscounts();

    }


}
