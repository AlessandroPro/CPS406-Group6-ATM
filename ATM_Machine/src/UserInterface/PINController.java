package UserInterface;

import BackEnd.ATMManager;
import BackEnd.Receipt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PINController {

    @FXML
    private Label lblError;

    @FXML
    private TextField txtInput;

    public void ProceedButton() throws IOException {
        int pin;
        try {
            pin = Integer.parseInt(txtInput.getText());
        } catch (NumberFormatException e) {
            lblError.setText("Invalid Input");
            return;
        }

        if (ATMManager.db.verifyAccoountPIN(pin)) {
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Main Menu");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenuScreen.fxml"))));
            ATMManager.receipt = new Receipt(ATMManager.db.getActiveAccount().getBalance(), ATMManager.db.getActiveAccount().getUserName());

        } else {
            lblError.setText((3 - ATMManager.db.getAttempts()) + " attempts remaining.");
            txtInput.setText("");
            if (ATMManager.db.doneThreeAttempts()) {
                Stage stage = (Stage) txtInput.getScene().getWindow();
                stage.setTitle("Login");
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("LoginScreen.fxml"))));
                ATMManager.db.setThreeAttempts(false);
                ATMManager.db.setAttempts(0);

            }
        }
    }
}
