package UserInterface;

import BackEnd.ATMManager;
import BackEnd.Receipt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/*
 * PINController controls the functionality of PIN screen.
 */
public class PINController implements Initializable {

    @FXML
    private Label lblError;

    @FXML
    private TextField txtInput;

    private String pin;

    /*
     * Checks for PIN validity and gives the user three tries. if exceeded returns the user to AccountScreen, else go to main screen
     */
    public void ProceedButton() throws IOException {
        if (pin.length() != 4 || !ATMManager.db.isNumeric(pin)) {
            lblError.setText("invalid input");
            return;
        }

        if (ATMManager.db.verifyAccountPIN(pin)) {
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

    /*
     * Restricts the input to 4 characters
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pin = "";
        txtInput.lengthProperty().addListener((observable, oldValue, newValue) -> {
            String rep = "";
            if (txtInput.getText().length() > 4)
                txtInput.setText(txtInput.getText().substring(0, 4));
            if(txtInput.getText().length() > pin.length())
                pin = pin + txtInput.getText().charAt(txtInput.getText().length() - 1);
            else if(txtInput.getText().length() < pin.length())
                pin = pin.substring(0, pin.length() - 1);
            for(int i = 0; i < txtInput.getText().length(); i++)
                rep += "*";
            txtInput.setText(rep);
        });
    }
}
