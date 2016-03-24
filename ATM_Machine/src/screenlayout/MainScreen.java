package screenlayout;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Created by Baheer on 2016-03-24.
 */
public class MainScreen extends Screen {

    private Content content;
    private Button[] buttonList;
    private Label text;

    public MainScreen() {
        buttonList = new Button[6];
        //set the layout for the left and right button and set the gap to 50 in both x and y
        GridPane layoutLeft = new GridPane();
        layoutLeft.setHgap(50);
        layoutLeft.setVgap(50);
        layoutLeft.setPrefSize(150, 300);
        GridPane layoutRight = new GridPane();
        layoutRight.setPrefSize(150, 300);
        layoutRight.setHgap(50);
        layoutRight.setVgap(50);

        int temp = 3;
        for (int i = 0; i < 3; i++, temp++) {
            buttonList[i] = new Button();
            buttonList[i].setPrefSize(100, 50);
            layoutLeft.add(buttonList[i], 1, 2 + (2 * i));
            buttonList[temp] = new Button();
            buttonList[temp].setPrefSize(100, 50);
            layoutRight.add(buttonList[temp], 0, 2 + (2 * i));
        }
        getLayout().setLeft(layoutLeft);
        getLayout().setRight(layoutRight);
        text = new Label();
        text.setPrefSize(100, 200);
        text.setWrapText(true);

        getLayout().setCenter(text);
        setContent(Content.MENU);
    }

    public void setContent(Content content) {
        this.content = content;
        updateScreen();
    }

    private void updateScreen() {
        for (int i = 0; i < 6; i++) {
            if (content.getContent()[i] == null || content.getContent()[i].equals("")) {
                buttonList[i].setText("");
                buttonList[i].setDisable(true);
            } else {
                buttonList[i].setDisable(false);
                buttonList[i].setText(content.getContent()[i]);
            }
        }

        text.setText(content.getContent()[6]);
    }

    enum Content {
        MENU("1", "2", "3", "4", "5", "6", "Welcome to Rams Bank International test test"),
        WITHDRAW("Withdraw", null, "", "", "", "", "Select the amount to withdraw");
        String[] context;

        Content(String... context) {
            this.context = context;
        }

        public String[] getContent() {
            return context;
        }
    }
}
