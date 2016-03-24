//package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Database implements Transaction 
{

    private Scanner dataScanner;
    private Account activeAccount;
    private File file = new File("database.txt");
	private Scanner scanner = new Scanner(file);

    public Database() throws FileNotFoundException 
    {
 
    }


    public void deposit(double amount) {
    	

    }

    public void withdraw(double amount) {
    	
    }

    //////////////////  BACK END (working with actual text file thing) ////////////////
    /*
     *  Checks account balance by account ID number
     *  MOCK FOR NOW
     */

    private boolean verifyAccountNumber(int IDnum)
    {
    	String details= "";
		String [] tokens;
		
		while(scanner.hasNext())
		{
			details = scanner.nextLine();
			tokens = details.split("[/]");
			
			if(Integer.parseInt(tokens[0]) == IDnum)
			{
				activeAccount = new Account(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),tokens[2],Double.parseDouble(tokens[3]));
				return true;
			}
						
		}
    	
        return false;
    }

    private boolean verifyAccoountPIN(int PIN){

        if(activeAccount.getPin() == PIN) return true;
        else return false;
    }

    
    private void update()
    {
    
    	
    	
    }
    
    
    
    
    
    
    
    private void writeBalance(Account account, double amount){


    }

}
