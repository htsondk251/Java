package com.company;

abstract class Ticket {
    private Long id;
//    private Gate _entry, _depart;
    private boolean active;
    private double value = 0;   //balance

    public Ticket(double initialValue) {
        this.value = initialValue;
    }

    public double getValue() {
        return value;
    }

    public void set_active(boolean _active) {
        this.active = _active;
    }

    public Long get_id() {
        return id;
    }
}
