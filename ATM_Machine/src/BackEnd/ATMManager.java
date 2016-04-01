package BackEnd;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ATMManager extends Application {
    public static Database db;
    public static Receipt receipt;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent loginParent = FXMLLoader.load(getClass().getResource("/UserInterface/MainMenuScreen.fxml"));
        Scene loginScreen = new Scene(loginParent);

        db = new Database("database.txt");
        receipt = new Receipt(200,"John Doe");

        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
        stage.setTitle("Login");
        stage.setScene(loginScreen);
        stage.show();
    }
}
