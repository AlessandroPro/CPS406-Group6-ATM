/**
 * Created by Baheer on 2016-03-24.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import screenlayout.MainScreen;

public class ATMManager extends Application {
    private static Database db;
    public static Receipt receipt;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainScreen view = new MainScreen();
        primaryStage.setResizable(false);
        primaryStage.setScene(view.getScene());
        primaryStage.show();

        db = new Database("database.txt");


        if(db.verifyAccountNumber(28820)) {
            System.out.println("Account Found!");
        }
        else {
            System.out.println("Account Not Found...");
            return;
        }

        if(db.verifyAccoountPIN(4783)) {
            System.out.println("PIN Correct");
        }
        else System.out.println("PIN Not Correct...");

        receipt = new Receipt(db.getActiveAccount().getBalance(), db.getActiveAccount().getUserName());

        db.withdraw(200);
        db.deposit(3000);

        System.out.println(receipt);

    }


}
