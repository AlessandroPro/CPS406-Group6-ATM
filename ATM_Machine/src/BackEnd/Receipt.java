package BackEnd;

import java.lang.Object;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;


public class Receipt {

    private Date date = new Date(); //gets current date to print along receipt
    private String receiptDate;    //Date Atm was accessed
    private ArrayList<String> transactions = new ArrayList<String>();
    private double balance = 0;        //Balance inside account
    private String userName;           //Name of the current user

    //Constructor for Receipt Class with original balance of Account accessed
    public Receipt(double bal, String name) {
        balance = bal;
        userName = name;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd h:mm:ss a");
        receiptDate = "ATM accessed on: " + dateFormat.format(date);
        transactions.add("----------------------------------------");
        transactions.add(receiptDate);
        transactions.add("ATM accessed by: " + userName);
        transactions.add("Initial balance: " + balance + "\n");
        transactions.add("Method	\t\tTime\t\t\tBalance\n");
    }

    //Method to add amount deposited and updated balance of account into ArrayList
    public void deposit(double amount) {
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");
        balance += amount;
        transactions.add("Deposit \t\t" + dateFormat.format(date) + "\t\t" + balance);
    }

    //Method to subtracted amount withdrawn and updated balance of account into ArrayList
    public void withdraw(double amount) {
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");
        balance -= amount;
        transactions.add("Withdrawal \t\t" + dateFormat.format(date) + "\t\t" + balance);
    }

    //Receipt toString to print all transactions
    public String toString() {
        String output = "";

        for (String temp : transactions) {
            output += temp + '\n';
        }
        output += "----------------------------------------\n";
        return output;

    }

}
