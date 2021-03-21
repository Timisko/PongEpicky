package sample;

import javafx.fxml.FXML;
import javafx.animation.AnimationTimer;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Game implements Initializable {
    @FXML
    public AnchorPane panel;
    @FXML
    public Circle lopta;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new AnimationTimer(){
            final long period = 20000000;
            int speedX = 2;
            int speedY = 5;
            long lastSampleTime = System.nanoTime();
            @Override
            public void handle(long l) {
                if (l - lastSampleTime > period){
                    lopta.setLayoutX(lopta.getLayoutX() + speedX);
                    lastSampleTime += period;
                }
            }
        }.start();
    }
}
