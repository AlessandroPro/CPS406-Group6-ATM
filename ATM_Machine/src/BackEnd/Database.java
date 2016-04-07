package BackEnd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Database class that interacts with the account and database textfile
 */
public class Database implements Transaction {
    private Account activeAccount;
    private FileWriter os;
    private File db;
    private Scanner reader;
    private int lineNumber;
    private int attempts;
    private boolean threeAttempts;

   /*
    * Constructor that attempts to open a file passed on by fn in res folder
    */
    public Database(String fn) throws IOException {
        db = new File("res/" + fn);
        if(db.exists()){
            reader = new Scanner(db);
        }
        else System.out.println("Database could not be found");
        attempts = 0;
    }

    /*
     * attempts to deposit amount directly to account and database
     */
    public void deposit(double amount) {
        activeAccount.deposit(amount);
        ATMManager.receipt.deposit(amount);
        if (!update(activeAccount.toString()))
            this.activeAccount.withdraw(amount);
    }

    /*
     * attempts to withdraw amount directly to account and database
     */
    public boolean withdraw(double amount) {
        if(activeAccount.withdraw(amount)) {
            ATMManager.receipt.withdraw(amount);
            if (!update(activeAccount.toString()))
                this.activeAccount.deposit(amount);
            return true;
        }
        return false;
    }

    /*
     * update method that updates the database.txt file.
     */
    public boolean update(String input) {
        try {
            String curr;
            reader = new Scanner(db);
            File tempFile = new File(db.getAbsolutePath() + ".tmp");
            os = new FileWriter(tempFile);

            for (int i = 1; reader.hasNext(); i++) {
                if (i == lineNumber) {
                    os.write(input + "\n");
                    reader.nextLine();
                } else {
                    curr = reader.nextLine();
                    os.write(curr + "\n");
                }
            }
            reader.close();
            os.close();

            if (!db.delete()) {
                System.out.println("Failed to remove file");
            }

            if (!tempFile.renameTo(db)) {
                System.out.println("Failed to rename file");
            }

        } catch (IOException e) {
            System.out.println("Error processing file");
            return false;
        }
        return true;
    }

    /*
     * method to retrieve the account from the database
     */
    public boolean verifyAccountNumber(String IDNum) throws IOException {
        reader = new Scanner(db);
        lineNumber = 0;
        String details = "";
        String[] tokens;

        while (reader.hasNext()) {
            lineNumber++;
            details = reader.nextLine();
            tokens = details.split("[/]");
            if (tokens[0].equals(IDNum)) {
                activeAccount = new Account(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                attempts = 0;
                return true;
            }
        }
        return false;
    }

    /*
     * verifies PIN (with a count)
     */

    public boolean verifyAccountPIN(String PIN) {
        attempts++;
        if (activeAccount.getPIN().equals(PIN)) {
            attempts = 0;
            return true;
        }
        else {
            if(attempts == 3)
                setThreeAttempts(true);
            return false;
        }
    }

    /*
     * checks if a string is numeric
     */
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray())
            if (!Character.isDigit(c)) return false;
        return true;
    }

    /*
     * returns the number of attempts
     */
    public int getAttempts() {
        return attempts;
    }

    /*
     * returns the active account
     */
    public Account getActiveAccount() { return activeAccount; }

    /*
     * indicates to the caller if there has been three attempts on PIN
     */
    public boolean doneThreeAttempts() { return threeAttempts; }

    /*
     * sets the number of attempts
     */
    public void setAttempts(int attempts){ this.attempts = attempts; }

    /*
     * sets the threeAttempts boolean
     */
    public void setThreeAttempts(boolean threeAttempts) { this.threeAttempts = threeAttempts; }
}
