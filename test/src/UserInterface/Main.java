package UserInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent DATParent = FXMLLoader.load(getClass().getResource("WithdrawScreen.fxml"));
        Scene DATScreen = new Scene(DATParent);

        stage.setTitle("DAT");
        stage.setScene(DATScreen);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
