package com.software.paymentservice.user;
import java.util.*;

import  com.software.paymentservice.Data.*;
import  com.software.paymentservice.service.*;
public class User {
	public String email; 
	public String userName;
	String passwrod;
	CreditCard myCrditCard;
	Wallet myWallet;
	Map<Integer,ServiceStatePair> completeServices;

	public User(String email,String userName,String password) {
		this.email = email;
		this.userName = userName;
		this.passwrod = password;
		myWallet = new Wallet();
		myCrditCard = new CreditCard();
		myCrditCard.add(1000);
		completeServices = new HashMap<Integer,ServiceStatePair>();
	}

	public Wallet getMyWallet() {
		return myWallet;
	}
	public CreditCard getCard() {
		return myCrditCard;
	}	
	public void addCompeleteServices(Service service) {
		ServiceStatePair serviceStatePair=new ServiceStatePair(0, service);
		completeServices.put(service.id, serviceStatePair);
		SavedData.getObj().setUsersCompleteService(completeServices);
	}
	public void showRefunds() {
		System.out.println("Press 1. Show Complete Services and make refund request");
		System.out.println("Press 2. Show Pending Services");
		System.out.println("Press 3. Show Accepted Services");
		System.out.println("Press 4. Show Rejected Services");
		int option=new Scanner(System.in).nextInt();
		int empty=0;
		if(option==1) {
			for(Map.Entry<Integer,ServiceStatePair> current :completeServices.entrySet()) {
				if(current.getValue().getState()==0)
				{
					 System.out.println("ID:"+current.getKey()+ "\t Service Name: "  + current.getValue().service.getName() );
					 empty++;
				}			
				
			}
			if(empty!=0) {

				
				while(true)
				{
					System.out.println("Enter service's ID : ");
					int id = new Scanner(System.in).nextInt();
					boolean success1 = Account.user.refund(id);
					completeServices.get(id).setState(2);
					if(success1)
						break;
				}
			}else {
				System.out.println("Empty..");
			}
			
		}else if(option==2) {
			for(Map.Entry<Integer,ServiceStatePair> current :completeServices.entrySet()) {
				if(current.getValue().getState()==2) {
					 System.out.println("ID:"+current.getKey()+ "\t Service Name: "  + current.getValue().service.getName() );
					 empty++;
				}
			}
			if(empty==0)
				System.out.println("Empty..");

				
		}else if(option==3) {
			for(Map.Entry<Integer,ServiceStatePair> current :completeServices.entrySet()) {
				if(current.getValue().getState()==1) {
					 System.out.println("ID:"+current.getKey()+ "\t Service Name: "  + current.getValue().service.getName() );
					 empty++;
				}
			}
			if(empty==0)
				System.out.println("Empty..");
			
		}else if(option==4) {
			for(Map.Entry<Integer,ServiceStatePair> current :completeServices.entrySet()) {
				if(current.getValue().getState()==-1) {
					 System.out.println("ID:"+current.getKey()+ "\t Service Name: "  + current.getValue().service.getName() );
					 empty++;
				}
			}
			if(empty==0)
				System.out.println("Empty..");
		}
	
	}
	public boolean refund(Integer ID) {	
		if(!completeServices.containsKey(ID)) {
			System.out.println("Invalid service !");
			return false;
		}
		SavedData.getObj().getRefundService().put(ID,Account.user);
		System.out.println("Your request is pending... ");
		return true;
	}
	public void addMoneyToWallet() {
		System.out.println("Enter the amount you want to add: ");
		int amount = new Scanner(System.in).nextInt();
		if(myCrditCard.getBalance()>=amount) {
			myCrditCard.spend(amount);
			myWallet.add(amount);
			System.out.println("Done Successfully..");

		}else
			System.out.println("There is not money..");
	}
	public void showDiscounts() {
		int noDiscounts=0;
			for(Map.Entry<String,Service> service :SavedData.getObj().services.entrySet()) {
				System.out.println(service.getKey()+": "+service.getValue().getDiscounts()*100+"%");
				if(service.getValue().getDiscounts()!=0.0)
					noDiscounts++;
			}
			if(noDiscounts==0)
				System.out.println("There is no discounts..");
			
	}
}
