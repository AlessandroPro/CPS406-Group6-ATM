package BackEnd;

/*
 * The interface indicating backend work of the atm
 */
public interface Transaction {
    void deposit(double amount);
    boolean withdraw(double amount);
}
