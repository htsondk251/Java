package com.company;

public class Gate {
    private String name;
    private long id;
    private boolean isOpen;

    public Gate(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    private void setIsOpen(boolean open) {
        isOpen = open;
    }

    public void open() {
        setIsOpen(true);
    }

    public void close() {
        setIsOpen(false);
    }

    public void in(long tickerId) {
        //connect to system
        //send info: codeCommand, gateId, ticketId
    }

    public void out(long ticketId) {
        //connect to system
        //send info: codeCommand, gateId, ticketId
    }

}
