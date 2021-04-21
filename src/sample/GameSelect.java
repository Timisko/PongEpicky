package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class GameSelect {
    public AnchorPane menu;

    public void back(MouseEvent mouseEvent) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("layout/menu.fxml"));
        menu.getChildren().setAll(pane);
    }

    public void startBotGame(MouseEvent mouseEvent) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("layout/game.fxml"));
        menu.getChildren().setAll(pane);
    }

    public void startVersusGame(MouseEvent mouseEvent) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("layout/versusGame.fxml"));
        menu.getChildren().setAll(pane);
    }
}
