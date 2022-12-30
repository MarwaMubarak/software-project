package com.software.paymentservice.payment;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.response.Response;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentServiceController {

    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    Response pay(@PathParam("discount") double discount, @PathParam("amount")double amount,@PathParam("paymentWay")int paymentWay){
        return SavedData.getObj().getPayment().pay(discount,amount);
    }

}
