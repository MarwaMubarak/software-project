package com.software.paymentservice.service;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.account.AccountController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    private Service service;

    @RequestMapping(value = "/serve",method = RequestMethod.POST)
    public String serve(@RequestBody ServiceInputModel serviceInputModel) {
        return SavedData.getObj().services.get("Landline").serve(serviceInputModel);
    }


}

