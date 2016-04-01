package UserInterface;

import BackEnd.ATMManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
        Stage stage = (Stage) txtDeposit.getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenuScreen.fxml"))));
    }

    @FXML
    private void ProceedButton() throws IOException {
        try {
            int amount;
            amount = Integer.parseInt(txtDeposit.getText());
            lblError.setText("");
            ATMManager.db.deposit(amount);


        } catch (NumberFormatException e) {
            lblError.setText("invalid entry");
            System.out.println("Invalid Input");
            return;
        }
        Stage stage = (Stage) txtDeposit.getScene().getWindow();
        stage.setTitle("Envelope");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("EnvelopeScreen.fxml"))));
    }
}
