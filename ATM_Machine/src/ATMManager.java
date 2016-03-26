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
    }


}
