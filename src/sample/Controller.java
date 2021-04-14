package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public BorderPane menu;
    public ImageView zvuk;
    public MediaPlayer player;
    public static int i = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hrajHudbu();
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

    public void zmenZvuk(MouseEvent mouseEvent){
        if (i == 0){
            InputStream inStream = getClass().getResourceAsStream("res/soundoff.png");
            Image imageObject = new Image(inStream);
            zvuk.setImage(imageObject);
            vypniZvuk();
            i = 1;
        }
        else {
            InputStream inStream = getClass().getResourceAsStream("res/soundon.png");
            Image imageObject = new Image(inStream);
            zvuk.setImage(imageObject);
            zapniZvuk();
            i = 0;
        }
    }

    public void infoOkno(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("layout/info.fxml"));
        menu.getChildren().setAll(pane);
    }

    public void hrajHudbu(){
        String path = Main.class.getResource("res/menu.mp3").toString();
        Media media = new Media(path);
        player = new MediaPlayer(media);
        player.setVolume(0.05);
        player.play();
    }

    public void vypniZvuk(){
        player.pause();
    }

    public void zapniZvuk(){
        player.play();
    }
}
