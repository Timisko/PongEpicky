package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Controller {
    public BorderPane menu;
    public String cierna;

    @FXML
    private void initialize(){
        cierna = "000000";
        menu.setStyle("-fx-background-color: #" + cierna);
    }


    public void herneOkno(ActionEvent actionEvent) throws IOException {

    }

    public void obchodOkno(ActionEvent actionEvent) {
    }

    public void exit(ActionEvent actionEvent) {
    }
}
