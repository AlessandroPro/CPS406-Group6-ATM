package UserInterface;

import BackEnd.ATMManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtInput;
    @FXML
    private Label lblError;

    public void ProceedButton() throws IOException {

        int uc;
        try {
           uc = Integer.parseInt(txtInput.getText());
        }
        catch(NumberFormatException e){
            lblError.setText("Invalid Input");
            return;
        }

        if(ATMManager.db.verifyAccountNumber(uc)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("PIN");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("PINScreen.fxml"))));
        }
        else
            lblError.setText("Account not found!");
    }
}
