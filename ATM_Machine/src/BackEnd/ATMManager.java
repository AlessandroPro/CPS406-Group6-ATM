package BackEnd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ATMManager extends Application {
    private static Database db;
    public static Receipt receipt;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent DATParent = FXMLLoader.load(getClass().getResource("/UserInterface/LoginScreen.fxml"));
        Scene DATScreen = new Scene(DATParent);

        stage.setTitle("DAT");
        stage.setScene(DATScreen);
        stage.show();

        db = new Database("database.txt");
    }
}
