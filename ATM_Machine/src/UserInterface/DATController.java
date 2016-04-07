package UserInterface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/*
 * DATController controls what happens on the Do Another Transaction Screen.
 */
public class DATController {

    @FXML
    private AnchorPane ap;

    /*
     * Functionality: return to main menu if user wants to perform another transaction
     */
    public void YesFunction() throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenuScreen.fxml"))));
    }

    /*
     * Functionality: go to receipt screen if user does not want to perform another transaction
     */
    public void NoFunction() throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        stage.setTitle("Receipt");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ReceiptScreen.fxml"))));
    }

}
