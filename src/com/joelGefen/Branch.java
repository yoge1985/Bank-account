package com.joelGefen;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    //add customer to the branch with an initial deposit.
    public boolean addCustomer(String name, double deposit){
        if (findCustomer(name) != null){
            System.out.println(name + " already exists");
            return false;
        }
        customers.add(new Customer(name,deposit));
        System.out.println(name + " has been added");
        return true;
    }

    //add transactions to an existing customer
    public boolean addTransactions(String customerName, double transaction){
        Customer checkCustomer = findCustomer(customerName);
        if (checkCustomer == null){
            System.out.println(name + " could not be found on file");
            return false;
        }

        checkCustomer.addTransactions(transaction);
        System.out.println("transaction added!");
        return true;
    }

    public int queryCustomer(String name){
        return this.customers.indexOf(name);
    }

    public Customer findCustomer(String customerName){

        for (int i = 0; i < this.customers.size(); i++){
            Customer checkCustomer = this.customers.get(i);
            if (checkCustomer.getCustomerName().equals(customerName)){
                return checkCustomer;
            }
        }
        return null;
    }

    public void printCustomers(){

        for (int i = 0; i < this.customers.size(); i++){
            System.out.println((i+1) + " . " + getName());
        }
    }
}
