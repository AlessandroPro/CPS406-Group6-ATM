package BackEnd;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * ATMManager class is the starting point for the applicaiton
 */
public class ATMManager extends Application {
    public static Database db;
    public static Receipt receipt;
    /*
     * main method to launch the application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /*
     * This is the point at which all the functions are called
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent loginParent = FXMLLoader.load(getClass().getResource("/UserInterface/LoginScreen.fxml"));
        Scene loginScreen = new Scene(loginParent);
        stage.setResizable(false);
        db = new Database("database.txt");
        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
        stage.setTitle("Login");
        stage.setScene(loginScreen);
        stage.show();
    }
}
