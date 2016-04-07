package BackEnd;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

/*
 * Receipt class hold all the transactions done within a session
 */
public class Receipt {

    private Date date = new Date(); //gets current date to print along receipt
    private String receiptDate;    //Date Atm was accessed
    private ArrayList<String> transactions = new ArrayList<String>();
    private double balance = 0;        //Balance inside account
    private String userName;           //Name of the current user

    /*
     * Constructor for Receipt Class with original balance of Account accessed
     */
    public Receipt(double bal, String name) {
        balance = bal;
        userName = name;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd h:mm:ss a");
        receiptDate = "ATM accessed on: " + dateFormat.format(date);
        transactions.add("------------------------------------------------------------------------------");
        transactions.add(receiptDate);
        transactions.add("ATM accessed by: " + userName);
        transactions.add("Initial balance: $" + String.format("%.2f", balance) + "\n");
        transactions.add("Method\t\t\tAmount\t\t\tTime\t\t\tBalance\n");
    }

    /*
     * Method to add amount deposited and updated balance of account into ArrayList
     */
    public void deposit(double amount) {
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");
        balance += amount;
        transactions.add("Deposit \t\t\t$" + String.format("%.2f", amount) + "\t\t\t" + dateFormat.format(date) + "\t\t\t$" + String.format("%.2f", balance));
    }

    /*
     * Method to subtracted amount withdrawn and updated balance of account into ArrayList
     */
    public boolean withdraw(double amount) {
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");
        balance -= amount;
        transactions.add("Withdrawal \t\t$" + String.format("%.2f", amount) + "\t\t\t" + dateFormat.format(date) + "\t\t\t$" + String.format("%.2f", balance));
        return true;
    }

    /*
     * Receipt toString to print all transactions
     */
    public String toString() {
        String output = "";

        for (String temp : transactions) {
            output += temp + '\n';
        }
        output += "------------------------------------------------------------------------------\n";
        return output;

    }

}
