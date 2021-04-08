package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Game implements Initializable {
    @FXML
    AnchorPane menu;
    @FXML
    Circle lopta;
    @FXML
    Rectangle Left;
    @FXML
    Rectangle Right;

    private int sirkaHrac = 10;
    private final int vyskaHrac = 50;

    private double hracY = 275;

    private final int leftX = 30;
    private final int rightX = 770;

    private final int loptaX = 400;
    private final int loptaY = 300;

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private int bodyHrac = 0;
    private int bodyPocitac = 0;

    static int PosY = 0;

    static boolean pokracuj = true;

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

                    //pohyb lopty
                    lopta.setLayoutX(lopta.getLayoutX() + speedX);
                    lopta.setLayoutY(lopta.getLayoutY() + speedY);

                    //odrazanie od hracov a zrychlovanie
                    if (
                            //podmienka pre pravu stranu
                            ((lopta.getLayoutX() > rightX) && (lopta.getLayoutY() >= Right.getLayoutY()) &&
                            (lopta.getLayoutY() <= Right.getLayoutY() + vyskaHrac))

                                    //podmienka pre lavu stranu
                                    || ((lopta.getLayoutX() < leftX) && (lopta.getLayoutY() >= Left.getLayoutY()) &&
                                    (lopta.getLayoutY() <= Left.getLayoutY() + vyskaHrac)))
                    {
                        speedX += 1 * Math.signum(speedX);
                        speedX *= -1;
                        speedY += 1 * Math.signum(speedY);
                        speedY *= -1;
                    }

                    //pohyb pocitaca
                    if(Right.getLayoutY() < WIDTH - WIDTH  / 4) {
                        Right.setLayoutY(lopta.getLayoutY() - vyskaHrac / 2);
                    }

                    //ked sa lopta dotkne vrchu alebo spodku obrazovky zmeni uhol
                    if(lopta.getLayoutY() > HEIGHT || lopta.getLayoutY() < 10) speedY *=-1;

                    //ak pocitac skoruje
                    if(lopta.getLayoutX() < leftX - sirkaHrac) {
                        bodyPocitac++;
                        lopta.setLayoutX(loptaX);
                        lopta.setLayoutY(loptaY);
                        Right.setLayoutY(hracY);
                        Left.setLayoutY(hracY);
                        speedX = 1;
                        speedY = 1;
                        System.out.println("Hrac "+bodyHrac+" : "+bodyPocitac+" Pocitac");
                        stop();
                        if (pokracuj)start();
                    }

                    //ak hrac skoruje
                    if(lopta.getLayoutX() > rightX + sirkaHrac) {
                        bodyHrac++;
                        lopta.setLayoutX(loptaX);
                        lopta.setLayoutY(loptaY);
                        Right.setLayoutY(hracY);
                        Left.setLayoutY(hracY);
                        speedX = 1;
                        speedY = 1;
                        System.out.println("Hrac "+bodyHrac+" : "+bodyPocitac+" Pocitac");
                        stop();
                        if (pokracuj)start();
                    }

                    lastSampleTime += period;
                }

                //podmienka potrebna pre pohyb pomocou klavesnice
                if (PosY !=0) Left.setLayoutY(Left.getLayoutY() + PosY);

            }
        }.start();
    }
}
