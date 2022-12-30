package com.software.paymentservice.payment;

import java.util.Scanner;

import com.software.paymentservice.account.AccountController;
import com.software.paymentservice.response.Response;

public class WalletPayment implements Payment{
	

	@Override
	public Response pay(double discount, double amount) {
		double amountAfterDiscounts = (1-discount)*amount;
		if(AccountController.userController.getUserModel().getMyWallet().getBalance()>=amountAfterDiscounts+getTaxes()) {
			AccountController.userController.getUserModel().getMyWallet().spend(amountAfterDiscounts+getTaxes());
			return new Response ("Done successfully..",amountAfterDiscounts+getTaxes());
		}
		else {
			//System.out.println("There is Not Enough Money");
			return new Response("There is Not Enough Money",-1.0);

		}
	}

	@Override
	public String getName() {
		return "WalletPayment";
		
	}

	@Override
	public double getTaxes() {
		return 1;
	}


}
