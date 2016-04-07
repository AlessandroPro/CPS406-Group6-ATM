package UserInterface;

import BackEnd.ATMManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/*
 * MainMenuController controls all functionality on Main Menu Screen
 */
public class MainMenuController {
    @FXML
    private Label lblBalanceAmount;


    /*
     * Directs to the deposit screen
     */
    @FXML
    public void DepositButton() throws IOException {
        Stage stage = (Stage) lblBalanceAmount.getScene().getWindow();
        stage.setTitle("Deposit");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DepositScreen.fxml"))));
    }

    /*
     * Directs to the withdraw screen
     */
    @FXML
    public void WithdrawButton() throws IOException {
        Stage stage = (Stage) lblBalanceAmount.getScene().getWindow();
        stage.setTitle("Withdraw");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("WithdrawScreen.fxml"))));
    }

    /*
     * Views balance
     */
    @FXML
    public void ViewBalanceButton() throws IOException {
        lblBalanceAmount.setText(Double.toString(ATMManager.db.getActiveAccount().getBalance()));
    }

    /*
     * Logs user out and goes back to login screen
     */
    @FXML
    public void ExitButton() throws IOException {
        Stage stage = (Stage) lblBalanceAmount.getScene().getWindow();
        stage.setTitle("Receipt");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ReceiptScreen.fxml"))));
    }
}
