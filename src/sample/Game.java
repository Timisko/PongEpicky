package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.animation.AnimationTimer;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Game implements Initializable {
    @FXML
    public AnchorPane panel;
    @FXML
    public Circle lopta;
    @FXML
    public Rectangle Left;
    @FXML
    public Rectangle Right;

    private double leftPaddleDY;
    private double leftPaddleY = 175;

    private int leftX = 30;
    private int rightX = 770;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new AnimationTimer(){
            final long period = 20000000;
            int speedX = 2;
            int speedY = 1;
            long lastSampleTime = System.nanoTime();


            @Override
            public void handle(long l) {
                if (l - lastSampleTime > period){
                    lopta.setLayoutX(lopta.getLayoutX() + speedX);
                    if (lopta.getLayoutX() >= rightX){
                        speedX =- speedX;
                    }
                    if (lopta.getLayoutX() <= leftX){
                        speedX = 2;
                    }
                    lastSampleTime += period;
                }
            }
        }.start();
    }


    private EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            // set movement to 0, if the released key was responsible for the paddle
            switch (event.getCode()) {
                case UP:
                case DOWN:
                    leftPaddleDY=0;
                    break;
            }
        }

    };

    private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            // start movement according to key pressed
            switch (event.getCode()) {
                case UP:
                    leftPaddleDY= -5;
                    break;
                case DOWN:
                    leftPaddleDY= 5;
                    break;
            }

        }
    };
}
