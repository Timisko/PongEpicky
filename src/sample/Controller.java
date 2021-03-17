package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;

import java.awt.*;

public class Controller {
    public BorderPane menu;
    public String cierna;

    @FXML
    private void initialize(){
        cierna = "000000";
        menu.setStyle("-fx-background-color: #" + cierna);
    }


    public void herneOkno(ActionEvent actionEvent) {
    }

    public void obchodOkno(ActionEvent actionEvent) {
    }

    public void exit(ActionEvent actionEvent) {
    }
}
