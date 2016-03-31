package UserInterface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by tolaz on 2016-03-30.
 */
public class DATController {

    @FXML
    private AnchorPane ap;

    public void YesFunction() throws IOException {
        System.out.println("YES button pressed");
        Stage stage = (Stage) ap.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml"))));
    }

    public void NoFunction() throws IOException {
        System.out.println("NO button pressed");
        Stage stage = (Stage) ap.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ReceiptScreen.fxml"))));
    }
}
