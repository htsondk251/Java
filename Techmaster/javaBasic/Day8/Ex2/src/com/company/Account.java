package com.company;

abstract class Account {
    private long id;
    private double balance;

    protected Account(long id, double balance) {
        setId(id);
        setBalance(balance);
    }

    private void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public void addValue(double amount) {
        setBalance(balance + amount);
    }

    public void subValue(double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("not enough money");
        } else {
            setBalance(balance - amount);
        }
    }

    public double monthlyInterest() {
        return 0.0;
    }
}
