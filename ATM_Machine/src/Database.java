//package sample;

import java.io.*;
import java.util.Scanner;

public class Database implements Transaction {
    private Account activeAccount;
    private FileWriter os;
    private File db;
    private Scanner reader;
    private int lineNumber;
    private int attempts;


    public Database(String fn) throws IOException {
        db = new File("res/" + fn);
        reader = new Scanner(db);
        attempts = 0;
    }

    public void deposit(double amount) {
        activeAccount.deposit(amount);
        ATMManager.receipt.deposit(amount);
        if (!update(activeAccount.toString()))
            this.activeAccount.withdraw(amount);
    }

    public void withdraw(double amount) {
        activeAccount.withdraw(amount);
        ATMManager.receipt.withdraw(amount);
        if (!update(activeAccount.toString()))
            this.activeAccount.deposit(amount);
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

    public boolean verifyAccountNumber(int IDnum) throws IOException {
        lineNumber = 0;
        String details = "";
        String[] tokens;

        while (reader.hasNext()) {
            lineNumber++;
            details = reader.nextLine();
            tokens = details.split("[/]");

            if (Integer.parseInt(tokens[0]) == IDnum) {
                activeAccount = new Account(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2], Double.parseDouble(tokens[3]));
                attempts = 0;
                return true;
            }
        }
        return false;
    }

    public boolean verifyAccoountPIN(int PIN) {
        attempts++;
        if (activeAccount.getPIN() == PIN) return true;
        else return false;
    }

    public int getAttempts() {
        return attempts;
    }
    public Account getActiveAccount() { return activeAccount; }
}
