package UserInterface;

import BackEnd.ATMManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

/*
 * ReceiptController control the receipt screen.
 */
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

    /*
     * When NO button is pressed, it does not print receipt
     */
    @FXML
    public void NoButton() throws IOException {
        Stage stage = (Stage) btnYes.getScene().getWindow();
        stage.setTitle("Exit");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ExitScreen.fxml"))));
    }

    /*
     * When YES button is pressed, it does not print receipt
     */
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

    /*
     * Proceeds back to login screen
     */
    @FXML
    public void DoneButton() throws IOException {
        Stage stage = (Stage) btnYes.getScene().getWindow();
        stage.setTitle("Exit");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ExitScreen.fxml"))));

    }
}