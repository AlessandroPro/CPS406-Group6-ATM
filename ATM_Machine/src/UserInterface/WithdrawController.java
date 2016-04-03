package UserInterface;

import BackEnd.ATMManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WithdrawController {
    @FXML
    private TextField txtInput;

    @FXML
    private Label lblError;

    @FXML
    public void BackButton() throws IOException {
        Stage stage = (Stage) txtInput.getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenuScreen.fxml"))));
    }

    public void ProceedButton() throws IOException {

        try {
            double amount = Double.parseDouble(txtInput.getText());
            if(amount % 20 != 0){
                lblError.setText("Not a multiple of 20");
                return;
            }
            else {
                if(ATMManager.db.withdraw(amount)) {
                    Stage stage = (Stage) txtInput.getScene().getWindow();
                    stage.setTitle("Do Another Transaction?");
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
                }
                else lblError.setText("Insufficient balance.");
            }
        }
        catch(NumberFormatException e) {
            lblError.setText("invalid input");
        }
    }

    public void Direct20() throws IOException {
        if(ATMManager.db.withdraw(20.0)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }
    public void Direct40() throws IOException {
        if(ATMManager.db.withdraw(40.0)) {
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }
    public void Direct60() throws IOException {
        if(ATMManager.db.withdraw(60.0)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }
    public void Direct80() throws IOException {
        if(ATMManager.db.withdraw(80.0)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }
    public void Direct100() throws IOException {
        if(ATMManager.db.withdraw(100.0)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }
    public void Direct200() throws IOException {
        if(ATMManager.db.withdraw(200.0)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }
}
