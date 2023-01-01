package com.software.paymentservice.admin;

import com.software.paymentservice.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class AdminServiceController {

    private AdminController adminController;

    public AdminServiceController(AdminController adminController) {
        this.adminController = adminController;
    }

    @RequestMapping(value = "/addDiscount", method = RequestMethod.POST)
    public Response addDiscount(@PathParam("choice") String choice, @PathParam("serviceName") String serviceName, @PathParam("amount") int amount) {
        return adminController.addDiscount(choice, serviceName, amount);
    }

    @RequestMapping(value = "/refundResponse", method = RequestMethod.POST)
    public Response refundResponse(@PathParam("id") int id, @PathParam("op") int op) {
        return adminController.refundResponse(id, op);
    }

    @RequestMapping(value = "/showRefund", method = RequestMethod.GET)
    public Response showRefund() {
        return adminController.showRefund();
    }

    @RequestMapping(value = "/showPaymentTransaction", method = RequestMethod.GET)
    public Response showPaymentTransaction() {
        return adminController.showPaymentTransaction();
    }

    @RequestMapping(value = "/showAddToWalletTransaction", method = RequestMethod.GET)
    public Response showAddToWalletTransaction() {
        return adminController.showAddToWalletTransaction();

    }

    @RequestMapping(value = "/showRefundTransaction", method = RequestMethod.GET)
    public Response showRefundTransaction() {
        return adminController.showRefundTransaction();
    }

    @RequestMapping(value = "/cashAvailability", method = RequestMethod.PUT)
    public Response cashAvailability(@PathParam("serviceName") String serviceName, @PathParam("visible") boolean visible) {
        return adminController.cashAvailability(serviceName, visible);
    }

}
