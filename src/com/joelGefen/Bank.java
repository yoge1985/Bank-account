package com.joelGefen;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public boolean addBranch(String branchName) {

        if (checkBranch(branchName) != null) {
            System.out.println(branchName + " already exists");
            return false;
        }

        branches.add(new Branch(branchName));
        return true;
    }

    public boolean addBranchCustomer(String branchName, String customerName, double deposit) {
        Branch foundBranch = checkBranch(branchName);
        if (foundBranch == null) {
            System.out.println(branchName + " not found on file");
            return false;

        }
        return foundBranch.addCustomer(customerName,deposit);
    }

    public boolean addBranchCustomerTransaction(String branchName, String customerName, double transaction){
        Branch searchBranch = checkBranch(branchName);
        if (searchBranch != null){
            return searchBranch.addTransactions(customerName,transaction);
        }
        return false;
    }


    public int queryBranch(String branchName) {
        return this.branches.indexOf(branchName);
    }


    public Branch checkBranch(String branchName) {

        for (int i = 0; i < this.branches.size(); i++) {
            Branch checkBranch = this.branches.get(i);
            if (checkBranch.getName().equals(branchName)) {
                return checkBranch;
            }
        }
        return null;
    }
    //print list of customers in a branch, and option to display customer transactions
    public boolean printBranchCustomers(String branchName, boolean transactions){

        Branch findBranch = checkBranch(branchName);
        if (findBranch != null){
            ArrayList<Customer> branchCustomers = new ArrayList<>(findBranch.getCustomers());
            for (int i = 0; i < branchCustomers.size(); i++){
                System.out.println((i+1) + " . " + branchCustomers.get(i).getCustomerName());

                if (transactions){
                    for (int j = 0; j < branchCustomers.size(); j++){
                        System.out.println(branchCustomers.get(i).getTransactions());
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
