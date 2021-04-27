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
        int peniaze = Integer.parseInt(br.readLine());
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


}
