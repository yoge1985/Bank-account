package com.joelGefen;

import java.util.ArrayList;

public class Customer {

    private String customerName;
    private double initialDeposit;
    private ArrayList<Double> transactions;

    public Customer(String customer, double deposit) {
        this.customerName = customer;
        this.transactions = new ArrayList<>();
        addTransactions(deposit);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getCustomerName() {
        return customerName;
    }

    public static Customer createNewCustomer(String name, double deposit){
        return new Customer(name,deposit);
    }

    public void addTransactions(double payment){

        this.transactions.add(payment);
    }

}
