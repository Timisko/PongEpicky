package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    public int pomoc1;
    public ImageView tick2;
    public ImageView dollar2;
    public Label label2;
    public int pomoc2;
    public ImageView dollar3;
    public Label label3;
    public ImageView tick3;
    public int pomoc3;
    public ImageView tick4;
    public ImageView dollar4;
    public Label label4;
    public int pomoc4;
    public ImageView tick5;
    public ImageView dollar5;
    public Label label5;
    public int pomoc5;
    public ImageView tick6;
    public ImageView dollar6;
    public Label label6;
    public int pomoc6;

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


    public void buyButton1(MouseEvent mouseEvent) throws IOException {
        dollar1.setVisible(false);
        label1.setVisible(false);
        tick1.setVisible(true);
        backgroundMask1.setBackground(null);
        buy1.setImage(null);
        if (pomoc1 < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc1++;
    }

    public void buyButton2(MouseEvent mouseEvent) {
        dollar2.setVisible(false);
        label2.setVisible(false);
        tick2.setVisible(true);
        backgroundMask2.setBackground(null);
        buy2.setImage(null);
        if (pomoc2 < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc2++;
    }

    public void buyButton3(MouseEvent mouseEvent) {
        dollar3.setVisible(false);
        label3.setVisible(false);
        tick3.setVisible(true);
        backgroundMask3.setBackground(null);
        buy3.setImage(null);
        if (pomoc3 < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc3++;
    }

    public void buyButton4(MouseEvent mouseEvent) {
        dollar4.setVisible(false);
        label4.setVisible(false);
        tick4.setVisible(true);
        backgroundMask4.setFill(null);
        backgroundMask4.setStroke(null);
        buy4.setImage(null);
        if (pomoc4 < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc4++;
    }

    public void buyButton5(MouseEvent mouseEvent) {
        dollar5.setVisible(false);
        label5.setVisible(false);
        tick5.setVisible(true);
        backgroundMask5.setFill(null);
        backgroundMask5.setStroke(null);
        buy5.setImage(null);
        if (pomoc5 < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc5++;
    }

    public void buyButton6(MouseEvent mouseEvent) {
        dollar6.setVisible(false);
        label6.setVisible(false);
        tick6.setVisible(true);
        backgroundMask6.setFill(null);
        backgroundMask6.setStroke(null);
        buy6.setImage(null);
        if (pomoc6 < 1) { peniaze -= 150;}
        money.setText(""+peniaze);
        pomoc6++;
    }
}
