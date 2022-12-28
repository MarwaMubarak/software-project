package com.software.paymentservice.user;

public class CreditCard {

	double balance=0.0;
	String cardNumber;
	public double getBalance()
	{
		return balance;
	}
	public void add(double amount) {
		balance+=amount;
	}
	public void spend(double amount) {
		balance-=amount;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	public String getCardNumber()
	{
		return cardNumber;
	}
	public void setCardNumber(String cardNumber)
	{
		this.cardNumber=cardNumber;
	}
	
}
