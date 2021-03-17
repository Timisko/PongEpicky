package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.InputStream;

public class Controller {
    public BorderPane menu;
    public String biela;
    public ImageView zvuk;
    int i = 0;

    @FXML
    private void initialize(){
        biela = "ffffffff";
        menu.setStyle("-fx-background-color: #" + biela);
    }


    public void herneOkno(ActionEvent actionEvent) {
    }

    public void obchodOkno(ActionEvent actionEvent) {
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void zmenZvuk(MouseEvent mouseEvent) {
        if (i == 0){
            InputStream inStream = getClass().getResourceAsStream("soundoff.png");
            Image imageObject = new Image(inStream);
            zvuk.setImage(imageObject);
            i = 1;
        }
        else {
            InputStream inStream = getClass().getResourceAsStream("soundon.png");
            Image imageObject = new Image(inStream);
            zvuk.setImage(imageObject);
            i = 0;
        }
    }
}
