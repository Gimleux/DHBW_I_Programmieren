package de.dhbwka.java.exercise.classes;

import de.dhbwka.java.utilities.console.Console;

public class Account {
    private int accountNumber;
    private String name;
    private double accountBalance;
    private double limitOnOverdrafts;

    public Account() {
        this.accountNumber = 666;
        this.name = "Satan";
        this.accountBalance = 666.666;
        this.limitOnOverdrafts = 66.6;
    }

    public Account(int accountNumber, String name, double accountBalance, double limitOnOverdrafts) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountBalance = accountBalance;
        this.limitOnOverdrafts = limitOnOverdrafts;
    }

    public void processDeposit(double value){
        if (value>0) this.accountBalance += value;
    }

    public void processPayment(double value){
        if (this.accountBalance-value>(-limitOnOverdrafts)) {
            this.accountBalance -= value;
        } else {
            Console.printlnColoredText("Deckung nicht ausreichend!", "red");
        }
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    @Override
    public String toString() {
        return "Kontonummer: " + accountNumber +
                " (" + name + ')' +
                ", Stand: " + accountBalance +
                "€, Limit " + limitOnOverdrafts +
                "€";
    }

    public static void main(String[] args) {
        Account account = new Account(4711, "Donald Duck", 500, 1000);
        System.out.println(account);
        account.processDeposit(200);
        System.out.println(account);
        account.processPayment(400);
        System.out.println(account);
        account.processPayment(2000);
        System.out.println(account);
    }
}
