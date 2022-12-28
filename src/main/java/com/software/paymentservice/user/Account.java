package com.software.paymentservice.user;

import  com.software.paymentservice.Data.SavedData;

public class Account {
	public String userEmail;
	public String userName;
	public String password;
	SavedData saveData;
	public static User  user; 
	public Account(String userName,String userEmail,String password){
		saveData = SavedData.getObj();
		this.userName=userName;
		this.userEmail=userEmail;
		this.password=password;
	}
	public boolean login(String email,String password)
	{
		
		if(saveData.getUserData().containsKey(email))
		{
			user = saveData.getUserData().get(email) ;
			if(user.passwrod.equals(password))
				return true;
			else 
				return false;
		}
		else return false;
	}
	public boolean signUp(String userName,String email,String password) {
		if(!saveData.getUserData().containsKey(email) && !saveData.getUserData().containsKey(userName)) {
			User user = new User(email,userName,password); 
			saveData.getUserData().put(email, user);
			saveData.getUserData().put(userName, user);
			return true;
		}
		else return false;
	}
}
