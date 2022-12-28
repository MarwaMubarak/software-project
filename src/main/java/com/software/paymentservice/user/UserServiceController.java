package com.software.paymentservice.user;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.Data.ServiceStatePair;
import com.software.paymentservice.request.Request;
import com.software.paymentservice.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

@RestController
public class UserServiceController {
    AccountController accountController;

    public UserServiceController(AccountController accountController) {
        this.accountController = accountController;
    }

    @GetMapping(value = "/showCompleteService")
    public String showCompleteService() {
        return accountController.userController.showCompleteService();
    }

    @PostMapping(value = "/refund")
    public String refund(@RequestBody Request<Integer> ID) {
        return accountController.userController.refund(ID.value);
    }
    @GetMapping(value = "/showPendingRequest")
    public String showPendingRequest() {
        return accountController.userController.showPendingRequest();
    }
    @GetMapping(value = "/showAcceptedService")
    public String showAcceptedService() {
        return accountController.userController.showAcceptedService();
    }
    @GetMapping(value = "/showRejectedRequest")
    public String showRejectedRequest() {
        return accountController.userController.showRejectedRequest();
    }


}
