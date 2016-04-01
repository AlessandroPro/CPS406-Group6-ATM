package UserInterface;

import BackEnd.ATMManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DATController {

    @FXML
    private AnchorPane ap;

    public void YesFunction() throws IOException {
        System.out.println("YES button pressed");
        Stage stage = (Stage) ap.getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenuScreen.fxml"))));
    }

    public void NoFunction() throws IOException {
        System.out.println("NO button pressed");
        Stage stage = (Stage) ap.getScene().getWindow();
        stage.setTitle("Receipt");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ReceiptScreen.fxml"))));
    }

}
