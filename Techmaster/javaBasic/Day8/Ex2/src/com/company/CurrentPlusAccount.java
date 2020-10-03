package com.company;

public class CurrentPlusAccount extends Account {
    private double interestRate, fee;

    public CurrentPlusAccount(long id, double balance, double interestRate, double fee) {
        super(id, balance);
        this.interestRate = interestRate;
        this.fee = fee;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getFee() {
        return fee;
    }

    @Override
    public void subValue(double amount) {
        super.subValue(amount + fee);
    }

    @Override
    public double monthlyInterest() {
        if (getBalance() < 0.0) {
            return 0.0;
        } else {
            return getBalance() * interestRate / 12;
        }
    }
}
