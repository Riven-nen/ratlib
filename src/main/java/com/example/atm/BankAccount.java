package com.example.atm;

public class BankAccount {
    private Account account;
    private String cardNo;

    public BankAccount(Account Account) {
        this.account = Account;
    }

    public Account getAccountType() {
        return this.account;
    }

    public void setAccountType(Account account) {
        this.account = account;
    }

    
}
