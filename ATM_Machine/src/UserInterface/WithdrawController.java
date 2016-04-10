package UserInterface;

import BackEnd.ATMManager;
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
 * WithdrawController controls the the Withdraw Screen
 */
public class WithdrawController implements Initializable{
    @FXML
    private TextField txtInput;

    @FXML
    private Label lblError;

    /*
     * returns user back to main menu
     */
    @FXML
    public void BackButton() throws IOException {
        Stage stage = (Stage) txtInput.getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenuScreen.fxml"))));
    }

    /*
     * Attempts to withdraw a custom amount (multiple of 20)
     */
    public void ProceedButton() throws IOException {

        try {
            double amount = Double.parseDouble(txtInput.getText());

            if(amount < 20){
                lblError.setText("invalid amount");
                txtInput.setText("");
                return;
            }

            else if(amount % 20 != 0){
                lblError.setText("not a multiple of 20");
                txtInput.setText("");
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

    /*
     * Directly attempt to $20
     */
    public void Direct20() throws IOException {
        if(ATMManager.db.withdraw(20.0)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }

    /*
     * Directly attempt to withdraw $40
     */
    public void Direct40() throws IOException {
        if(ATMManager.db.withdraw(40.0)) {
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }

    /*
     * Directly attempt to withdraw $60
     */
    public void Direct60() throws IOException {
        if(ATMManager.db.withdraw(60.0)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }

    /*
     * Directly attempt to withdraw $80
     */
    public void Direct80() throws IOException {
        if(ATMManager.db.withdraw(80.0)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }

    /*
     * Directly attempt to withdraw $100
     */
    public void Direct100() throws IOException {
        if(ATMManager.db.withdraw(100.0)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }

    /*
     * Directly attempt to withdraw $200
     */
    public void Direct200() throws IOException {
        if(ATMManager.db.withdraw(200.0)){
            Stage stage = (Stage) txtInput.getScene().getWindow();
            stage.setTitle("Do Another Transaction?");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DATScreen.fxml"))));
        }
        else lblError.setText("Insufficient balance.");
    }

    /*
     * Ensure input is no bigger than $9980
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtInput.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if (txtInput.getText().length() > 4)
                txtInput.setText(txtInput.getText().substring(0, 4));
        });
    }
}
