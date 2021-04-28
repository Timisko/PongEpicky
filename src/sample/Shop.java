package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Shop implements Initializable {
    public AnchorPane menu;
    public ImageView buy2;
    public ImageView buy3;
    public AnchorPane backgroundMask1;
    public ImageView buy1;
    public ImageView buy4;
    public AnchorPane backgroundMask2;
    public AnchorPane backgroundMask3;
    public Circle backgroundMask4;
    public Circle backgroundMask5;
    public ImageView buy5;
    public ImageView buy6;
    public Circle backgroundMask6;
    public Label money;
    public ImageView tick1;
    public ImageView dollar1;
    public Label label1;
    public int peniaze;
    public int [] pomoc= new int[6];
    public ImageView tick2;
    public ImageView dollar2;
    public Label label2;
    public ImageView dollar3;
    public Label label3;
    public ImageView tick3;
    public ImageView tick4;
    public ImageView dollar4;
    public Label label4;
    public ImageView tick5;
    public ImageView dollar5;
    public Label label5;
    public ImageView tick6;
    public ImageView dollar6;
    public Label label6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("peniaze.txt"));
        peniaze = Integer.parseInt(br.readLine());
        money.setText(""+peniaze);
    }


    public void back(MouseEvent mouseEvent) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("layout/menu.fxml"));
        menu.getChildren().setAll(pane);
    }

    public void background1(MouseEvent mouseEvent) {
        backgroundMask1.setVisible(true);
        backgroundMask2.setVisible(false);
        backgroundMask3.setVisible(false);
        backgroundMask4.setVisible(false);
        backgroundMask5.setVisible(false);
        backgroundMask6.setVisible(false);
        buy1.setVisible(true);
        buy2.setVisible(false);
        buy3.setVisible(false);
        buy4.setVisible(false);
        buy5.setVisible(false);
        buy6.setVisible(false);
    }

    public void background2(MouseEvent mouseEvent) {
        backgroundMask1.setVisible(false);
        backgroundMask2.setVisible(true);
        backgroundMask3.setVisible(false);
        backgroundMask4.setVisible(false);
        backgroundMask5.setVisible(false);
        backgroundMask6.setVisible(false);
        buy1.setVisible(false);
        buy2.setVisible(true);
        buy3.setVisible(false);
        buy4.setVisible(false);
        buy5.setVisible(false);
        buy6.setVisible(false);
    }

    public void background3(MouseEvent mouseEvent) {
        backgroundMask1.setVisible(false);
        backgroundMask2.setVisible(false);
        backgroundMask3.setVisible(true);
        backgroundMask4.setVisible(false);
        backgroundMask5.setVisible(false);
        backgroundMask6.setVisible(false);
        buy1.setVisible(false);
        buy2.setVisible(false);
        buy3.setVisible(true);
        buy4.setVisible(false);
        buy5.setVisible(false);
        buy6.setVisible(false);
    }

    public void background4(MouseEvent mouseEvent)  {
        backgroundMask1.setVisible(false);
        backgroundMask2.setVisible(false);
        backgroundMask3.setVisible(false);
        backgroundMask4.setVisible(true);
        backgroundMask5.setVisible(false);
        backgroundMask6.setVisible(false);
        buy1.setVisible(false);
        buy2.setVisible(false);
        buy3.setVisible(false);
        buy4.setVisible(true);
        buy5.setVisible(false);
        buy6.setVisible(false);
    }

    public void background5(MouseEvent mouseEvent) {
        backgroundMask1.setVisible(false);
        backgroundMask2.setVisible(false);
        backgroundMask3.setVisible(false);
        backgroundMask4.setVisible(false);
        backgroundMask5.setVisible(true);
        backgroundMask6.setVisible(false);
        buy1.setVisible(false);
        buy2.setVisible(false);
        buy3.setVisible(false);
        buy4.setVisible(false);
        buy5.setVisible(true);
        buy6.setVisible(false);
    }

    public void background6(MouseEvent mouseEvent) {
        backgroundMask1.setVisible(false);
        backgroundMask2.setVisible(false);
        backgroundMask3.setVisible(false);
        backgroundMask4.setVisible(false);
        backgroundMask5.setVisible(false);
        backgroundMask6.setVisible(true);
        buy1.setVisible(false);
        buy2.setVisible(false);
        buy3.setVisible(false);
        buy4.setVisible(false);
        buy5.setVisible(false);
        buy6.setVisible(true);
    }
    public void buyButton(ImageView dollar, Label label, ImageView tick, AnchorPane backgroundMask, ImageView buy)throws IOException{
        dollar.setVisible(false); label.setVisible(false); tick.setVisible(true); backgroundMask.setBackground(null); buy.setImage(null);
    }
    public void buyButtonBall(ImageView dollar, Label label, ImageView tick, Circle backgroundMask, ImageView buy)throws IOException{
        dollar.setVisible(false); label.setVisible(false); tick.setVisible(true); backgroundMask.setFill(null); backgroundMask.setStroke(null); buy.setImage(null);
    }

    public void buyButton1(MouseEvent mouseEvent) throws IOException {
        buyButton(dollar1, label1, tick1, backgroundMask1, buy1);
        if (pomoc[0] < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc[0]++;
    }

    public void buyButton2(MouseEvent mouseEvent) throws IOException{
        buyButton(dollar2, label2, tick2, backgroundMask2, buy2);
        if (pomoc[1] < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc[1]++;
    }

    public void buyButton3(MouseEvent mouseEvent) throws IOException{
        buyButton(dollar3, label3, tick3, backgroundMask3, buy3);
        if (pomoc[2] < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc[2]++;
    }

    public void buyButton4(MouseEvent mouseEvent) throws IOException{
        buyButtonBall(dollar4, label4, tick4, backgroundMask4, buy4);
        if (pomoc[3] < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc[3]++;
    }

    public void buyButton5(MouseEvent mouseEvent) throws IOException{
        buyButtonBall(dollar5, label5, tick5, backgroundMask5, buy5);
        if (pomoc[4] < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc[4]++;
    }

    public void buyButton6(MouseEvent mouseEvent) throws IOException{
        buyButtonBall(dollar6, label6, tick6, backgroundMask6, buy6);
        if (pomoc[5] < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc[5]++;
    }

}
