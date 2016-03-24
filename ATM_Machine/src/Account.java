



public class Account implements Transaction{         

    private double balance;
    private int IDNum;
    private int pin;
    private String userName;
    private Database database;

    //Account constructor to initialize the Account ID, Pin, Name, and Balance
    public Account(int ID, int pin,String uName, double balance){

        this.balance = balance;
        this.IDNum = ID;
        this.userName = uName;
        this.pin = pin;

    }

    //Returns Balance of account
    public double getBalance()
    { 
    	return balance; 
    }

    //Deposits amount into account balance
    public void deposit(double amount) 
    {
    //	database.deposit(this, amount); 
    }
    
    //Withdraws Amount from account balance
    public void withdraw(double amount) 
    { 
    	//database.withdraw(this,amount); 
    }
    
    //Return account ID number
    public int getID()
    { 
    	return IDNum; 
    }

	public int getPin() {
		return pin;
	}

  //public String getUserName(){ return userName;}
  //public String printAcc(){ return "Name: " + userName + "// ID: " + IDNum + "// Balance: " + balance;}
}
