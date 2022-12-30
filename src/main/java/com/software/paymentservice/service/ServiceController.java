package com.software.paymentservice.service;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.response.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @RequestMapping(value = "/serve",method = RequestMethod.POST)
    public Response serve(@RequestBody ServiceInputModel serviceInputModel) {
        return SavedData.getObj().services.get(serviceInputModel.getServiceName()).serve(serviceInputModel);
    }


}

