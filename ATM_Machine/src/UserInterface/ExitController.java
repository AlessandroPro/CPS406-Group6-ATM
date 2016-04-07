package UserInterface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/*
 * ExitController control the exit screen.
 */

public class ExitController {

    @FXML
    AnchorPane ap;

    /*
     * Sends user back to the login screen
     */
    @FXML
    public void FinishButton() throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("LoginScreen.fxml"))));
    }
}
