package BackEnd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Database implements Transaction {
    private Account activeAccount;
    private FileWriter os;
    private File db;
    private Scanner reader;
    private int lineNumber;
    private int attempts;
    private boolean threeAttempts;


    public Database(String fn) throws IOException {
        db = new File("res/" + fn);
        if(db.exists()){
            reader = new Scanner(db);
            System.out.println("Database was found");
        }
        else System.out.println("Database could not be found");
        attempts = 0;
    }

    public void deposit(double amount) {
        activeAccount.deposit(amount);
        ATMManager.receipt.deposit(amount);
        if (!update(activeAccount.toString()))
            this.activeAccount.withdraw(amount);
    }

    public boolean withdraw(double amount) {
        if(activeAccount.withdraw(amount)) {
            ATMManager.receipt.withdraw(amount);
            if (!update(activeAccount.toString()))
                this.activeAccount.deposit(amount);
            return true;
        }
        return false;
    }

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

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray())
            if (!Character.isDigit(c)) return false;
        return true;
    }

    public int getAttempts() {
        return attempts;
    }
    public Account getActiveAccount() { return activeAccount; }
    public boolean doneThreeAttempts() { return threeAttempts; }
    public void setAttempts(int attempts){ this.attempts = attempts; }
    public void setThreeAttempts(boolean threeAttempts) { this.threeAttempts = threeAttempts; }
}