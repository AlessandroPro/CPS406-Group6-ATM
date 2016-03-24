package screenlayout;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * Created by Baheer on 2016-03-24.
 */
public abstract class Screen {

    public static final int HEIGHT = 500;
    public static final int WIDTH = 700;
    private Scene scene;
    private BorderPane layout;

    public Screen() {
        layout = new BorderPane();
        scene = new Scene(layout, WIDTH, HEIGHT);
    }

    public BorderPane getLayout() {
        return layout;
    }

    public final Scene getScene() {
        return scene;
    }

}
