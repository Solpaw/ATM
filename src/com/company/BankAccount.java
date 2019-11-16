package com.company;

import java.util.Iterator;

public class BankAccount {
    private String accountNumber;
    private String pinNumber;
    private float balance;

    public BankAccount(String num, String pin, float balance) {
        this.accountNumber = num;
        this.pinNumber = pin;
        this.balance = balance;
    }

    public void makeDeposit(float amount) {
        this.balance+=amount;
    }

    public void withdrawFunds(float amount) {
        this.balance-=amount;
    }

    public float getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getPinNumber() {
        return this.pinNumber;
    }

    @Override
    public String toString() {
        return this.accountNumber + " " + this.pinNumber + " " + this.balance;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o instanceof BankAccount) {
            if(this.accountNumber==((BankAccount) o).accountNumber) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.accountNumber);
    }
}
