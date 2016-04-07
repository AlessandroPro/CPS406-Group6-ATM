package UserInterface;

import BackEnd.ATMManager;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/*
 * DepositController controls what happens on the Deposit Screen and Envelope Screen
 */
public class DepositController {

    @FXML
    private TextField txtDeposit;

    @FXML
    private Button btnEProceed;

    @FXML
    private Label lblError;

    private static int amount;

    /*
     * Functionality: when back button is pressed, the user is returned to the Main Menu screen
     */
    @FXML
    private void BackButton() throws IOException {
        Stage stage = (Stage) txtDeposit.getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenuScreen.fxml"))));
    }

    /*
     * Functionality: When proceed button is pressed, the amount is set, and sent to the envelope screen
     */
    @FXML
    private void ProceedButton() throws IOException {
        try {
            this.amount = Integer.parseInt(txtDeposit.getText());
            lblError.setText("");
        } catch (NumberFormatException e) {
            lblError.setText("invalid entry");
            return;
        }
        Stage stage = (Stage) lblError.getScene().getWindow();
        stage.setTitle("Envelope");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("EnvelopeScreen.fxml"))));
    }

    /*
     * Functionality: deposit the amount and take in the envelope
     */
    @FXML
    private void EProceedButton() throws IOException {
        ATMManager.db.deposit(amount);
        Stage stage = (Stage) btnEProceed.getScene().getWindow();
        stage.setTitle("Envelope");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        this.amount = 0;
    }
}
