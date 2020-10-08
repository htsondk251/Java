package com.HoangSon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    // private String id, name;
    private List<Employee> employees = new ArrayList<>();

    // public Company(String id, String name) {}

    public void go() { // interface
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the ABC company.");

        // boolean flag = false;
        while (true) {
            System.out.print("Please enter the command: ");
            String cmd = in.nextLine();
            String[] cmdArr = cmd.split(" ");
            switch (cmdArr[2]) {
                case "show":
                    String id = cmdArr[3];
                    System.out.println(get(id));
                    break;
                case "all":
                    System.out.println(getAll());
                    break;
                case "add":
                    id = cmdArr[3];
                    System.out.println(add(new Employee()));
                    break;
                case "update":
                    id = cmdArr[3];
                    String name = cmdArr[4].substring(5);       //handle ArrayIndexOutOfBoundsException
                    System.out.println(update(id, name));
                    break;
                case "delete":
                    id = cmdArr[3];
                    System.out.println(delete(id));
                    break;
                default:
                    System.out.println("fail");
                    
            }
            System.out.print("continue? y/n ");
            cmd = in.nextLine();
            if (cmd.equalsIgnoreCase("n")) {
                // flag = false;
                break;
            }
        }
        in.close();
    }

    public Employee add(Employee e) {
        System.out.println("add one Employee's info");
        return null;
    }

    public Employee get(String id) {
        System.out.println("read one Employee's info");
        return null;
    }

    public List<Employee> getAll() {
        System.out.println("read all Employees' info");
        return employees;
    }

    public Employee update(String id, String name) {
        System.out.println("update one Employee's info");
        return null;
    }

    public Employee delete(String id) {
        System.out.println("delete one Employee's info");
        return null;
    }

}
