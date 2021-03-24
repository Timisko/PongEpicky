package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Shop {
    public void back(MouseEvent mouseEvent) throws IOException {
        Parent menuWindow = FXMLLoader.load(getClass().getResource("layout/sample.fxml"));
        Scene menuScene = new Scene(menuWindow, 800, 600);

        Stage windowMenu = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        windowMenu.setScene(menuScene);
        windowMenu.show();
    }
}
