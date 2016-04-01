package UserInterface;

import BackEnd.ATMManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceiptController {
    @FXML
    TextArea txtAreaTransactions;
    @FXML
    Label lblTransactionsTitle;
    @FXML
    Label lblReceiptPrompt;
    @FXML
    Button btnYes;
    @FXML
    Button btnNo;
    @FXML
    Button btnDone;

    @FXML
    public void NoButton() throws IOException {
        Stage stage = (Stage) btnYes.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("LoginScreen.fxml"))));
        stage.setTitle("Login");
    }

    @FXML
    public void YesButton(){
        btnYes.setVisible(false);
        btnNo.setVisible(false);
        lblReceiptPrompt.setVisible(false);
        txtAreaTransactions.setVisible(true);
        lblTransactionsTitle.setVisible(true);
        btnDone.setVisible(true);
        txtAreaTransactions.setText(ATMManager.receipt.toString());
    }

    @FXML
    public void DoneButton() throws IOException {
        Stage stage = (Stage) btnYes.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("LoginScreen.fxml"))));
        stage.setTitle("Login");
    }
}