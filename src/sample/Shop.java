package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Shop {
    public AnchorPane menu;

    public void back(MouseEvent mouseEvent) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("layout/sample.fxml"));
        menu.getChildren().setAll(pane);
    }
}
