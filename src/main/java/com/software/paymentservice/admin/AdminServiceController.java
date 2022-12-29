package com.software.paymentservice.admin;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.Data.ServiceStatePair;
import com.software.paymentservice.Screen.UI;
import com.software.paymentservice.discount.Discount;
import com.software.paymentservice.discount.DiscountFactory;
import com.software.paymentservice.user.UserController;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Scanner;

@RestController
public class AdminServiceController {
    AdminController adminController;

    public AdminServiceController(AdminController adminController) {
        this.adminController = adminController;
    }

    @RequestMapping(value = "/addDiscount",method = RequestMethod.POST)
    public String addDiscount(@PathParam("choice") String choice,@PathParam("serviceName") String serviceName,@PathParam("amount") int amount) {
        return adminController.addDiscount( choice, serviceName, amount);
    }

    @RequestMapping(value = "/refundResponse", method = RequestMethod.POST)
    public String refundResponse(@PathParam("id") int id, @PathParam("op") int op) {
        return adminController.refundResponse(id, op);
    }

    @RequestMapping(value = "/showrefund", method = RequestMethod.GET)
    public String showRefund() {
        return adminController.showRefund();
    }


    @RequestMapping(value = "/showPaymentTransaction", method = RequestMethod.GET)
    public String showPaymentTransaction() {
        return adminController.showPaymentTransaction();
    }

    @RequestMapping(value = "/showAddToWalletTransaction", method = RequestMethod.GET)
    public String showAddToWalletTransaction() {
        return adminController.showPaymentTransaction();

    }

    @RequestMapping(value = "/showRefundTransaction", method = RequestMethod.GET)
    public String showRefundTransaction() {
        return adminController.showRefundTransaction();
    }


    @RequestMapping(value="/cashAvailability",method =RequestMethod.PUT )
    public String cashAvailability(@PathParam ("serviceName") String serviceName,@PathParam ("visible")boolean visible ){
        return adminController.cashAvailability(serviceName,visible);
    }

}
