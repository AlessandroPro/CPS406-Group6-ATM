package UserInterface;

import BackEnd.ATMManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    @FXML
    private Label lblBalanceAmount;


    @FXML
    public void DepositButton() throws IOException {
        System.out.println("Deposit Button Pressed!");
        Stage stage = (Stage) lblBalanceAmount.getScene().getWindow();
        stage.setTitle("Deposit");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DepositScreen.fxml"))));
    }

    @FXML
    public void WithdrawButton() throws IOException {
        System.out.println("Withdraw Button Pressed!");
        Stage stage = (Stage) lblBalanceAmount.getScene().getWindow();
        stage.setTitle("Withdraw");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("WithdrawScreen.fxml"))));
    }

    @FXML
    public void ViewBalanceButton() throws IOException {
        System.out.println("View Balance Button Pressed!");
        lblBalanceAmount.setText(Double.toString(ATMManager.db.getActiveAccount().getBalance()));
    }

    @FXML
    public void ExitButton() throws IOException {
        System.out.println("Exit Button Pressed!");
        Stage stage = (Stage) lblBalanceAmount.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("LoginScreen.fxml"))));
    }
}
