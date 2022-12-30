package com.software.paymentservice.user;

public class Wallet {
    double balance;

    public Wallet() {
        balance = 0;
    }

    public void add(double amount) {
        balance += amount;
    }

    public void spend(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
