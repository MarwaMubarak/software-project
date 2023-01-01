package com.software.paymentservice.account;

public class AccountModel {

    private String userEmail;
    private String userName;
    private String password;

    public AccountModel() {

    }

    public AccountModel(String userEmail, String userName, String password) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.password = password;
    }

    public AccountModel(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
