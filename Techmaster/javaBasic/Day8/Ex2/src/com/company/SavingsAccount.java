package com.company;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(long id, double balance, double interestRate) {
        super(id, balance);
//        this.interest = interest;
        setInterestRate(interestRate);
    }

    public void setInterestRate(double interest) {
        this.interestRate = interest;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public double monthlyInterest() {
        return getBalance() * interestRate / 12;
    }
}
