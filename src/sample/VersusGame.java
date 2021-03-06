package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class VersusGame implements Initializable {
    Random rd = new Random();

    public Label skore;
    public AnchorPane pause;
    public BorderPane menu;
    public AnchorPane koniec;
    public Label vitaz;
    public ImageView pauseTlacitko;
    public ImageView pozadie;

    @FXML
    AnchorPane panel;
    @FXML
    Circle lopta;
    @FXML
    Rectangle Left;
    @FXML
    Rectangle Right;

    private final int sirkaHrac = 10;
    private final double vyskaHrac = 70.0;

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

    int vitazneGoly = 5;
    String pozadieCesta = "";
    String loptaCesta = "";

    static boolean pokracuj = true;

    int speedX;
    int speedY;

    int [] zaciatok = {2, -2};

    public void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("nastavenia.txt"));

        while (true){
            String s = br.readLine();

            if (s == null)
                break;

            //dlzka hry
            if (s.equals("5")){
                vitazneGoly = 5;
            }
            if (s.equals("10")){
                vitazneGoly = 10;
            }


            //pozadie
            if (s.equals("pC")){
                pozadieCesta = "res/cPozadie.jpg";
            }
            if (s.equals("pF")){
                pozadieCesta = "res/fPozadie.jpg";
            }
            if (s.equals("pB")){
                pozadieCesta = "res/bPozadie.jpg";
            }
            if (s.equals("pV")){
                pozadieCesta = "res/vPozadie.jpg";
            }

            //lopta
            if (s.equals("lC")){
                loptaCesta = "res/cLopta.png";
            }
            if (s.equals("lF")){
                loptaCesta = "res/fLopta.png";
            }
            if (s.equals("lB")) {
                loptaCesta = "res/bLopta.png";
            }
            if (s.equals("lV")) {
                loptaCesta = "res/vLopta.png";
            }
        }

        br.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //nastavenie pozadia
        pozadie.setImage(new Image(Game.class.getResourceAsStream(pozadieCesta)));

        //lopta image
        lopta.setFill(new ImagePattern(new Image(Game.class.getResourceAsStream(loptaCesta))));

        //nahodny vyber smeru lopty na zaciatku hry
        speedX = zaciatok[rd.nextInt(2)];
        speedY = zaciatok[rd.nextInt(2)];
        
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


                            //odrazanie od stredu Prava
                            if (lopta.getLayoutY() >= (Right.getLayoutY() + (vyskaHrac / 3))  &&
                                    lopta.getLayoutY() <= (Right.getLayoutY() + (2 * (vyskaHrac / 3))) ){
                                speedY = 0;
                            }

                            //odrazanie od stredu Lava
                            if (lopta.getLayoutY() >= (Left.getLayoutY() + (vyskaHrac / 3))  &&
                                    lopta.getLayoutY() <= (Left.getLayoutY() + (2 * (vyskaHrac / 3))) ){
                                speedY = 0;
                            }

                            //odrazanie od vrchu Prava
                            if (lopta.getLayoutY() >= Right.getLayoutY() &&
                                    lopta.getLayoutY() <= (Right.getLayoutY() + (vyskaHrac / 3))) {
                                speedY = -2;
                            }

                            //odrazanie od vrchu Lava
                            if (lopta.getLayoutY() >= Left.getLayoutY() &&
                                    lopta.getLayoutY() <= (Left.getLayoutY() + (vyskaHrac / 3))) {
                                speedY = -2;
                            }

                            //odrazanie od spodu Prava
                            if (lopta.getLayoutY() >= Right.getLayoutY() + (2 * (vyskaHrac / 3)) &&
                                    lopta.getLayoutY() <= (Right.getLayoutY() + vyskaHrac)) {
                                speedY = 2;
                            }

                            //odrazanie od vrchu Lava
                            if (lopta.getLayoutY() >= Left.getLayoutY() + (2 * (vyskaHrac / 3)) &&
                                    lopta.getLayoutY() <= (Left.getLayoutY() + vyskaHrac)) {
                                speedY = 2;
                            }

                            //otocenie x
                            speedX *= -1;

                            //zrychlenie x
                            speedX += 1 * Math.signum(speedX);

                            //zrychlenie y
                            speedY += 1 * Math.signum(speedY);

                        }

                        //ked sa lopta dotkne vrchu alebo spodku obrazovky zmeni uhol
                        if (lopta.getLayoutY() + 10 > HEIGHT || lopta.getLayoutY() - 10 < 0) speedY *= -1;

                        //ak pocitac skoruje
                        if (lopta.getLayoutX() < leftX - lopta.getRadius()) {
                            bodyPocitac++;
                            lopta.setLayoutX(loptaX);
                            lopta.setLayoutY(loptaY);
                            Right.setLayoutY(startY);
                            Left.setLayoutY(startY);

                            //nahodny vyber smeru lopty na zaciatku hry
                            speedX = zaciatok[rd.nextInt(2)];
                            speedY = zaciatok[rd.nextInt(2)];

                            skore.setText(bodyHrac + " : " + bodyPocitac);
                        }

                        //ak hrac skoruje
                        if (lopta.getLayoutX() > rightX + lopta.getRadius()) {
                            bodyHrac++;
                            lopta.setLayoutX(loptaX);
                            lopta.setLayoutY(loptaY);
                            Right.setLayoutY(startY);
                            Left.setLayoutY(startY);

                            //nahodny vyber smeru lopty na zaciatku hry
                            speedX = zaciatok[rd.nextInt(2)];
                            speedY = zaciatok[rd.nextInt(2)];

                            skore.setText(bodyHrac + " : " + bodyPocitac);
                        }

                        //ukoncenie hry ak vyhra hrac 1
                        if (bodyHrac == vitazneGoly){
                            stop();
                            pauseTlacitko.setVisible(false);
                            vitaz.setText("Vyhral hr???? ????slo 1");
                            koniec.setVisible(true);
                        }

                        //ukoncenie hry ak vyhra hrac 2
                        if (bodyPocitac == vitazneGoly){
                            stop();
                            pauseTlacitko.setVisible(false);
                            vitaz.setText("Vyhral hr???? ????slo 2");
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
