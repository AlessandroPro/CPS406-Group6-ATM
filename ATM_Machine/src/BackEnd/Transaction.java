package BackEnd;


public interface Transaction {

    void deposit(double amount);
    boolean withdraw(double amount);

}
