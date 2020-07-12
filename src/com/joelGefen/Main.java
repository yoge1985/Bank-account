package com.joelGefen;

import java.util.Scanner;

public class Main {

    private static Bank bank = new Bank("Natwest");
    private static Scanner scanner1 = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("select from the following options:");
        printOptions();
        boolean quit = false;
        while (!quit){
            System.out.print("enter options(press 0 for list of options):");
            int choice = scanner1.nextInt();
            scanner1.nextLine();

            switch (choice){
                case 0:
                    printOptions();
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    addBranchCustomer();
                    break;
                case 3:
                    displayBranchCustomers();
                    break;
                case 4:
                    quit = true;
                    break;
            }

        }

    }

    private static void printOptions(){
        System.out.println("0 - print options\n1 - add branch\n2 - add customer\n3 - add transactions" +
                "\n4 - display transactions");
    }

    private static void addBranch(){
        System.out.print("enter name of branch: ");
        String branchName = scanner1.nextLine();
        bank.addBranch(branchName);
    }

    private static void addBranchCustomer() {
        System.out.print("enter name of branch:");
        String branchName = scanner1.nextLine();
        int checkBranch = bank.queryBranch(branchName);
        if (checkBranch > 0) {
            System.out.println(branchName + " does not exist");
        } else {
            System.out.print("enter customer name: ");
            String customerName = scanner1.nextLine();
            System.out.print("enter initial deposit:");
            double deposit = scanner1.nextDouble();
            bank.addBranchCustomer(branchName, customerName, deposit);

        }

    }

    private static void displayBranchCustomers(){
        System.out.print("enter branch:");
        String branchSelected = scanner1.nextLine();
        System.out.println("do you want the transactions displayed:");
        bank.printBranchCustomers(branchSelected,true);


    }
}
