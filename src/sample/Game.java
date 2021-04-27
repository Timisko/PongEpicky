package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Game implements Initializable {
    public ImageView pozadie;
    Random rd = new Random();

    public Label skore;
    public Label money;
    public AnchorPane pause;
    public BorderPane menu;
    public Label vitaz;
    public AnchorPane koniec;
    public ImageView pauseTlacitko;
    public AnchorPane panel;
    public Circle lopta;
    public Rectangle Left;
    public Rectangle Right;
    public int peniazePomoc;

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

    static int PosY = 0;

    static boolean pokracuj = true;

    int [] zaciatok = {2, -2};

    int speedX;
    int speedY;

    int narocnost = 2;
    int vitazneGoly = 5;

    String pozadieCesta = "";
    String loptaCesta = "";

    public void load() throws IOException {
        BufferedReader br2 = new BufferedReader(new FileReader("peniaze.txt"));
        peniazePomoc = Integer.parseInt(br2.readLine());
        peniaze += peniazePomoc;
        money.setText(""+peniaze);
        br2.close();

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

            //narocnost
            if (s.equals("L")){
                narocnost = 2;
            }
            if (s.equals("S")){
                narocnost = 4;
            }
            if (s.equals("T")){
                narocnost = 6;
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

        //pozadie
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

                        //pohyb pocitaca
                        if (lopta.getLayoutY() > Right.getLayoutY())
                        {
                            Right.setLayoutY(Right.getLayoutY() + narocnost);
                        }
                        else
                        {
                            Right.setLayoutY(Right.getLayoutY() - narocnost);
                        }

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
                            peniaze += 10;
                            money.setText(peniaze + "");
                            lopta.setLayoutX(loptaX);
                            lopta.setLayoutY(loptaY);
                            Right.setLayoutY(startY);
                            Left.setLayoutY(startY);

                            //nahodny vyber smeru lopty na zaciatku hry
                            speedX = zaciatok[rd.nextInt(2)];
                            speedY = zaciatok[rd.nextInt(2)];

                            skore.setText(bodyHrac + " : " + bodyPocitac);
                        }

                        //ukoncenie hry ak hrac 1 dosiahne pozadovany pocet golov
                        if (bodyHrac == vitazneGoly){
                            stop();

                            if (narocnost == 2){
                                peniaze += 25;
                                money.setText(peniaze + "");
                            }

                            else if (narocnost == 4){
                                peniaze += 50;
                                money.setText(peniaze + "");
                            }

                            else if (narocnost == 6){
                                peniaze += 100;
                                money.setText(peniaze + "");
                            }

                            pauseTlacitko.setVisible(false);
                            vitaz.setText("Vyhral hráč číslo 1");
                            koniec.setVisible(true);

                        }

                        //ukoncenie hry ak hrac 2 dosiahne pozadovany pocet golov
                        if (bodyPocitac == vitazneGoly){
                            stop();
                            pauseTlacitko.setVisible(false);
                            vitaz.setText("Vyhral hráč číslo 2");
                            koniec.setVisible(true);

                        }

                        lastSampleTime += period;
                    }

                    //podmienka potrebna pre pohyb pomocou klavesnice
                    if (PosY != 0) Left.setLayoutY(Left.getLayoutY() + PosY);

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

    public void zapis() throws IOException {
        peniazePomoc = peniaze;
        BufferedWriter bw = new BufferedWriter(new FileWriter("peniaze.txt"));
        bw.write(""+peniazePomoc);
        bw.close();
    }

    public void back(ActionEvent actionEvent) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("layout/menu.fxml"));
        menu.getChildren().setAll(pane);
        zapis();
        pokracuj = true;
    }
}
