package com.company;

public class CurrentAccount extends Account {
    private double fee;

    public CurrentAccount(long id, double balance, double fee) {
        super(id, balance);
        setFee(fee);
    }

    @Override
    public void subValue(double amount) {
        super.subValue(amount + fee);
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }
}
