package UserInterface;

import BackEnd.ATMManager;
import BackEnd.Database;
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

public class LoginController implements Initializable{

    @FXML
    private TextField txtInput;

    @FXML
    private Label lblError;

    public void ProceedButton() throws IOException {
        String input = txtInput.getText();
        if(input.length() != 16) {
            lblError.setText("invalid input");
            return;
        }
        if(!Database.isNumeric(input)){
            lblError.setText("invalid input");
            return;
        }

        if(ATMManager.db.verifyAccountNumber(input)) {
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("PIN");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("PINScreen.fxml"))));
        }
        else {
            lblError.setText("Account not found!");
            txtInput.setText("");
        }
    }
    public void initialize(URL location, ResourceBundle resources) {
        txtInput.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if (txtInput.getText().length() > 16)
                txtInput.setText(txtInput.getText().substring(0, 16));
        });
    }
}
