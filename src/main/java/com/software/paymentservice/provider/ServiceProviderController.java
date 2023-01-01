package com.software.paymentservice.provider;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ServiceProviderController {

    @RequestMapping(value = "/setInfo", method = RequestMethod.GET)
    public Response setInfo(@PathParam("amount") double amount, @PathParam("info") String info, @PathParam("providerId") int providerId) {
        return SavedData.getObj().getServiceProvider().setInfo(amount, info);
    }
}
