package com.software.paymentservice;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.user.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) {
//		UserController user = new UserController("d","doha","123");
//		SavedData.getObj().getUserData().put("d",user);

		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
