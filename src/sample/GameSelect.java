package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class GameSelect {

    public void back(MouseEvent mouseEvent) throws IOException {
        Parent GameSelectWindow = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene GameSelectScene = new Scene(GameSelectWindow, 800, 600);

        Stage windowShop = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        windowShop.setScene(GameSelectScene);
        windowShop.show();
    }
}
