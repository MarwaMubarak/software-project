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

    public void addDiscount() {
        Discount discount;
        DiscountFactory discountFactory = new DiscountFactory();
        discount = discountFactory.create();
        discount.addDiscount();
    }

    @RequestMapping(value = "/refundResponse", method = RequestMethod.POST)
    public String refundResponse(@PathParam("id") int id, @PathParam("op") int op) {
        return adminController.refundResponse(id, op);
    }

    @RequestMapping(value = "/showrefund", method = RequestMethod.GET)
    public String showRefund() {
        return adminController.showRefund();
    }

//    public void cashAvailability() {
//        System.out.println("Enter Service Name to set Cash avaliablity: ");
//        UI.servicesOptions();
//        String serviceName = new Scanner(System.in).next();
//        System.out.println("Enter true or false");
//        boolean visible = new Scanner(System.in).nextBoolean();
//        SavedData.getObj().services.get(serviceName).setCash(visible);
//
//    }

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


}
