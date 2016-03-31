package UserInterface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DepositController {


    @FXML
    private TextField txtDeposit;
    @FXML
    private Label lblError;

    @FXML
    private void BackButton() throws IOException {
        System.out.println("Back Button Pressed!");
        Stage stage = (Stage) txtDeposit.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml"))));
    }

    @FXML
    private void ProceedButton() {
        int amount;
        System.out.println("Proceed Button Pressed!");
        try {
            amount = Integer.parseInt(txtDeposit.getText());
            lblError.setText("");
        } catch (NumberFormatException e){
            lblError.setText("invalid entry");
            System.out.println("Invalid Input");
        }

    }

    @FXML
    private void ExitButton() throws IOException {
        System.out.println("Exit Button Pressed!");
        Stage stage = (Stage) txtDeposit.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
    }
}
