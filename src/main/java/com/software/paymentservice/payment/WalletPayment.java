package com.software.paymentservice.payment;

import java.util.Scanner;

import com.software.paymentservice.account.AccountController;

public class WalletPayment implements Payment{
	

	@Override
	public double pay(double discount,double amount) {
		double amountAfterDiscounts = (1-discount)*amount;
		if(AccountController.userController.getUserModel().getMyWallet().getBalance()>=amountAfterDiscounts+getTaxes()) {
			AccountController.userController.getUserModel().getMyWallet().spend(amountAfterDiscounts+getTaxes());
			return amountAfterDiscounts+getTaxes();
		}
		else {
			System.out.println("There is Not Enough Money");
			return -1;

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
