package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VersusGame implements Initializable {
    public Label skore;
    public Label money;
    public AnchorPane pause;
    public BorderPane menu;
    public AnchorPane koniec;

    @FXML
    AnchorPane panel;
    @FXML
    Circle lopta;
    @FXML
    Rectangle Left;
    @FXML
    Rectangle Right;

    public int peniaze = 0;

    private final int sirkaHrac = 10;
    private final int vyskaHrac = 70;

    private double startY = 215;

    private final int leftX = 30;
    private final int rightX = 770;

    private final int loptaX = 400;
    private final int loptaY = 250;

    private final int WIDTH = 600;
    private final int HEIGHT = 500;

    private int bodyHrac = 0;
    private int bodyPocitac = 0;

    static int Pos1Y = 0;
    static int Pos2Y = 0;

    static boolean pokracuj = true;

    int speedX = 2;
    int speedY = 2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*
        lopta.setFill(new ImagePattern(new Image(Game.class.getResourceAsStream("res/fLopta.png"))));*/

        new AnimationTimer() {
            final long period = 20000000;
            long lastSampleTime = System.nanoTime();

            @Override
            public void handle(long l) {
                if (pokracuj){
                    if (l - lastSampleTime > period) {
                        //pohyb lopty
                        lopta.setLayoutX(lopta.getLayoutX() + speedX);
                        lopta.setLayoutY(lopta.getLayoutY() + speedY);

                        //zamedzenie vychadzania hracov z herneho pola
                        if (Left.getLayoutY() <= 0) {
                            Left.setLayoutY(0);
                        }
                        if (Left.getLayoutY() + vyskaHrac >= HEIGHT) {
                            Left.setLayoutY(HEIGHT - vyskaHrac);
                        }

                        if (Right.getLayoutY() <= 0) {
                            Right.setLayoutY(0);
                        }
                        if (Right.getLayoutY() + vyskaHrac >= HEIGHT) {
                            Right.setLayoutY(HEIGHT - vyskaHrac);
                        }

                        //odrazanie od hracov a zrychlovanie
                        if (
                            //podmienka pre pravu stranu
                                ((lopta.getLayoutX() > rightX) && (lopta.getLayoutY() >= Right.getLayoutY()) &&
                                        (lopta.getLayoutY() <= Right.getLayoutY() + vyskaHrac))

                                        //podmienka pre lavu stranu
                                        || ((lopta.getLayoutX() < leftX) && (lopta.getLayoutY() >= Left.getLayoutY()) &&
                                        (lopta.getLayoutY() <= Left.getLayoutY() + vyskaHrac))) {

                            speedX += 1 * Math.signum(speedX);
                            speedX *= -1;
                            speedY += 1 * Math.signum(speedY);
                            speedY *= -1;
                        }

                        //ked sa lopta dotkne vrchu alebo spodku obrazovky zmeni uhol
                        if (lopta.getLayoutY() + 10 > HEIGHT || lopta.getLayoutY() - 10 < 0) speedY *= -1;

                        //ak hrac skoruje
                        if (lopta.getLayoutX() < leftX - sirkaHrac) {
                            bodyPocitac++;
                            lopta.setLayoutX(loptaX);
                            lopta.setLayoutY(loptaY);
                            Right.setLayoutY(startY);
                            Left.setLayoutY(startY);
                            speedX = 2;
                            speedY = 2;
                            skore.setText(bodyHrac + " : " + bodyPocitac);
                        }

                        //ak hrac skoruje
                        if (lopta.getLayoutX() > rightX + sirkaHrac) {
                            bodyHrac++;
                            lopta.setLayoutX(loptaX);
                            lopta.setLayoutY(loptaY);
                            Right.setLayoutY(startY);
                            Left.setLayoutY(startY);
                            speedX = 2;
                            speedY = 2;
                            skore.setText(bodyHrac + " : " + bodyPocitac);
                        }

                        if (bodyHrac == 5 || bodyPocitac == 5){
                            stop();
                            koniec.setVisible(true);
                        }

                        lastSampleTime += period;
                    }

                    //podmienka potrebna pre pohyb pomocou klavesnice
                    if (Pos1Y != 0) Left.setLayoutY(Left.getLayoutY() + Pos1Y);
                    if (Pos2Y != 0) Right.setLayoutY(Right.getLayoutY() + Pos2Y);

                }}
        }.start();
    }

    public void pauza(MouseEvent mouseEvent) {
        pokracuj = false;
        pause.setVisible(true);
    }

    public void unpause(ActionEvent actionEvent) {
        pokracuj = true;
        pause.setVisible(false);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("layout/menu.fxml"));
        menu.getChildren().setAll(pane);
        pokracuj = true;
    }
}
