/**
 * Created by Baheer on 2016-03-24.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import sample.layout.MainScreen;

public class ATMManager extends Application {


    public ATMManager() {

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainScreen view = new MainScreen();
        primaryStage.setResizable(false);
        primaryStage.setScene(view.getScene());
        primaryStage.show();
    }


}
