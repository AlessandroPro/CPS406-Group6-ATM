package UserInterface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WithdrawController {
    @FXML
    private TextField txtInput;

    @FXML
    public void BackButton() throws IOException {
        System.out.println("Back Button Pressed!");
        Stage stage = (Stage) txtInput.getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenuScreen.fxml"))));
    }
}
