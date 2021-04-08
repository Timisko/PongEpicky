package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class Controller {
    public BorderPane menu;
    public String biela;
    public ImageView zvuk;
    int i = 0;

    @FXML
    private void initialize(){
        biela = "ffffff";
        menu.setStyle("-fx-background-color: #" + biela);
    }


    public void herneOkno(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("layout/gameselect.fxml"));
        menu.getChildren().setAll(pane);
    }

    public void obchodOkno(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("layout/shop.fxml"));
        menu.getChildren().setAll(pane);
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void zmenZvuk(MouseEvent mouseEvent) {
        if (i == 0){
            InputStream inStream = getClass().getResourceAsStream("res/soundoff.png");
            Image imageObject = new Image(inStream);
            zvuk.setImage(imageObject);
            i = 1;
        }
        else {
            InputStream inStream = getClass().getResourceAsStream("res/soundon.png");
            Image imageObject = new Image(inStream);
            zvuk.setImage(imageObject);
            i = 0;
        }
    }

    public void infoOkno(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("layout/info.fxml"));
        menu.getChildren().setAll(pane);
    }
}
