package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

import java.io.*;
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
    public ImageView pF;
    public ImageView pB;
    public ImageView pV;
    public ImageView lF;
    public ImageView lB;
    public ImageView lV;


    String dlzkaHry;
    String obtiaznost;
    String pozadie;
    String lopta;
    String odomknutePozadia;
    String odomknuteLopty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //nastavenie zobrazenia pozadi, ktore mame uz kupene
        if (odomknutePozadia.equals("000")){
            pF.setVisible(true);
            pB.setVisible(true);
            pV.setVisible(true);
            tick1.setVisible(false);
            tick2.setVisible(false);
            tick3.setVisible(false);
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            dollar1.setVisible(true);
            dollar2.setVisible(true);
            dollar3.setVisible(true);
        }
        if (odomknutePozadia.equals("100")){
            pF.setVisible(false);
            pB.setVisible(true);
            pV.setVisible(true);
            tick1.setVisible(true);
            tick2.setVisible(false);
            tick3.setVisible(false);
            label1.setVisible(false);
            label2.setVisible(true);
            label3.setVisible(true);
            dollar1.setVisible(false);
            dollar2.setVisible(true);
            dollar3.setVisible(true);

        }
        if (odomknutePozadia.equals("110")){
            pF.setVisible(false);
            pB.setVisible(false);
            pV.setVisible(true);
            tick1.setVisible(true);
            tick2.setVisible(true);
            tick3.setVisible(false);
            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(true);
            dollar1.setVisible(false);
            dollar2.setVisible(false);
            dollar3.setVisible(true);
        }
        if (odomknutePozadia.equals("111")){
            pF.setVisible(false);
            pB.setVisible(false);
            pV.setVisible(false);
            tick1.setVisible(true);
            tick2.setVisible(true);
            tick3.setVisible(true);
            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            dollar1.setVisible(false);
            dollar2.setVisible(false);
            dollar3.setVisible(false);
        }
        if (odomknutePozadia.equals("010")){
            pF.setVisible(true);
            pB.setVisible(false);
            pV.setVisible(true);
            tick1.setVisible(false);
            tick2.setVisible(true);
            tick3.setVisible(false);
            label1.setVisible(true);
            label2.setVisible(false);
            label3.setVisible(true);
            dollar1.setVisible(true);
            dollar2.setVisible(false);
            dollar3.setVisible(true);
        }
        if (odomknutePozadia.equals("011")){
            pF.setVisible(true);
            pB.setVisible(false);
            pV.setVisible(false);
            tick1.setVisible(false);
            tick2.setVisible(true);
            tick3.setVisible(true);
            label1.setVisible(true);
            label2.setVisible(false);
            label3.setVisible(false);
            dollar1.setVisible(true);
            dollar2.setVisible(false);
            dollar3.setVisible(false);
        }
        if (odomknutePozadia.equals("001")){
            pF.setVisible(true);
            pB.setVisible(true);
            pV.setVisible(false);
            tick1.setVisible(false);
            tick2.setVisible(false);
            tick3.setVisible(true);
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(false);
            dollar1.setVisible(true);
            dollar2.setVisible(true);
            dollar3.setVisible(false);
        }
        if (odomknutePozadia.equals("101")){
            pF.setVisible(false);
            pB.setVisible(true);
            pV.setVisible(false);
            tick1.setVisible(true);
            tick2.setVisible(false);
            tick3.setVisible(true);
            label1.setVisible(false);
            label2.setVisible(true);
            label3.setVisible(false);
            dollar1.setVisible(false);
            dollar2.setVisible(true);
            dollar3.setVisible(false);
        }

        //nastavenie zobrazenia lopt, ktore mame uz kupene
        if (odomknuteLopty.equals("000")){
            lF.setVisible(true);
            lB.setVisible(true);
            lV.setVisible(true);
            tick4.setVisible(false);
            tick5.setVisible(false);
            tick6.setVisible(false);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            dollar4.setVisible(true);
            dollar5.setVisible(true);
            dollar6.setVisible(true);
        }
        if (odomknuteLopty.equals("100")){
            lF.setVisible(false);
            lB.setVisible(true);
            lV.setVisible(true);
            tick4.setVisible(true);
            tick5.setVisible(false);
            tick6.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(true);
            label6.setVisible(true);
            dollar4.setVisible(false);
            dollar5.setVisible(true);
            dollar6.setVisible(true);
        }
        if (odomknuteLopty.equals("110")){
            lF.setVisible(false);
            lB.setVisible(false);
            lV.setVisible(true);
            tick4.setVisible(true);
            tick5.setVisible(true);
            tick6.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(true);
            dollar4.setVisible(false);
            dollar5.setVisible(false);
            dollar6.setVisible(true);
        }
        if (odomknuteLopty.equals("111")){
            lF.setVisible(false);
            lB.setVisible(false);
            lV.setVisible(false);
            tick4.setVisible(true);
            tick5.setVisible(true);
            tick6.setVisible(true);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(false);
            dollar4.setVisible(false);
            dollar5.setVisible(false);
            dollar6.setVisible(false);
        }
        if (odomknuteLopty.equals("010")){
            lF.setVisible(true);
            lB.setVisible(false);
            lV.setVisible(true);
            tick4.setVisible(false);
            tick5.setVisible(true);
            tick6.setVisible(false);
            label4.setVisible(true);
            label5.setVisible(false);
            label6.setVisible(true);
            dollar4.setVisible(true);
            dollar5.setVisible(false);
            dollar6.setVisible(true);
        }
        if (odomknuteLopty.equals("011")){
            lF.setVisible(true);
            lB.setVisible(false);
            lV.setVisible(false);
            tick4.setVisible(false);
            tick5.setVisible(true);
            tick6.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(false);
            label6.setVisible(false);
        }
        if (odomknuteLopty.equals("001")){
            lF.setVisible(true);
            lB.setVisible(true);
            lV.setVisible(false);
            tick4.setVisible(false);
            tick5.setVisible(false);
            tick6.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(false);
            dollar4.setVisible(true);
            dollar5.setVisible(true);
            dollar6.setVisible(false);
        }
        if (odomknuteLopty.equals("101")){
            lF.setVisible(false);
            lB.setVisible(true);
            lV.setVisible(false);
            tick4.setVisible(true);
            tick5.setVisible(false);
            tick6.setVisible(true);
            label4.setVisible(false);
            label5.setVisible(true);
            label6.setVisible(false);
            dollar4.setVisible(false);
            dollar5.setVisible(true);
            dollar6.setVisible(false);
        }

    }

    public void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("peniaze.txt"));
        peniaze = Integer.parseInt(br.readLine());
        money.setText("" + peniaze);

        BufferedReader br2 = new BufferedReader(new FileReader("nastavenia.txt"));
        dlzkaHry = br2.readLine();
        obtiaznost = br2.readLine();
        pozadie = br2.readLine();
        lopta = br2.readLine();
        odomknutePozadia = br2.readLine();
        odomknuteLopty = br2.readLine();
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
        if (pomoc[0] < 1 && peniaze>=150) {
            buyButton(dollar1, label1, tick1, backgroundMask1, buy1);
            peniaze -= 150;
            money.setText(""+peniaze);
            pomoc[0]++;
            ZapisPozadia(100);}
    }

    public void buyButton2(MouseEvent mouseEvent) throws IOException{
        if (pomoc[1] < 1 && peniaze>=150) {
            buyButton(dollar2, label2, tick2, backgroundMask2, buy2);
            peniaze -= 150;
            money.setText(""+peniaze);
            pomoc[1]++;
            ZapisPozadia(10);}
    }

    public void buyButton3(MouseEvent mouseEvent) throws IOException{
        if (pomoc[2] < 1 && peniaze>=150) {
            buyButton(dollar3, label3, tick3, backgroundMask3, buy3);
            peniaze -= 150;
            money.setText(""+peniaze);
            pomoc[2]++;
            ZapisPozadia(1);}
    }

    public void buyButton4(MouseEvent mouseEvent) throws IOException{
        if (pomoc[3] < 1 && peniaze>=150) {
            buyButtonBall(dollar4, label4, tick4, backgroundMask4, buy4);
            peniaze -= 150;
            money.setText(""+peniaze);
            pomoc[3]++;
            ZapisLopty(100);}
    }

    public void buyButton5(MouseEvent mouseEvent) throws IOException{
        if (pomoc[4] < 1 && peniaze>=150) {
            buyButtonBall(dollar5, label5, tick5, backgroundMask5, buy5);
            peniaze -= 150;
            money.setText(""+peniaze);
            pomoc[4]++;
            ZapisLopty(10);}
    }

    public void buyButton6(MouseEvent mouseEvent) throws IOException{
        if (pomoc[5] < 1 && peniaze>=150) {
            buyButtonBall(dollar6, label6, tick6, backgroundMask6, buy6);
            peniaze -= 150;
            money.setText(""+peniaze);
            pomoc[5]++;
            ZapisLopty(1);}
    }

    public void ZapisPozadia(int n) throws IOException {
        String[]odomknute=odomknutePozadia.split("");
        if (n==100){odomknutePozadia="1"+odomknute[1]+""+odomknute[2];}
        if (n==10){odomknutePozadia=odomknute[0]+"1"+odomknute[2];}
        if (n==1){odomknutePozadia=odomknute[0]+""+odomknute[1]+"1";}
        BufferedWriter bout = new BufferedWriter(new FileWriter("nastavenia.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter("peniaze.txt"));

        out.write(peniaze);

        bout.write(dlzkaHry);
        bout.newLine();
        bout.write(obtiaznost);
        bout.newLine();
        bout.write(pozadie);
        bout.newLine();
        bout.write(lopta);
        bout.newLine();
        bout.write(odomknutePozadia);
        bout.newLine();
        bout.write(odomknuteLopty);
        bout.close();
    }
    public void ZapisLopty(int n) throws IOException {
        String[]odomknute=odomknuteLopty.split("");
        if (n==100){odomknuteLopty="1"+odomknute[1]+""+odomknute[2];}
        if (n==10){odomknuteLopty=odomknute[0]+"1"+odomknute[2];}
        if (n==1){odomknuteLopty=odomknute[0]+""+odomknute[1]+"1";}

        System.out.println(odomknutePozadia);
        BufferedWriter bout = new BufferedWriter(new FileWriter("nastavenia.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter("peniaze.txt"));

        out.write(peniaze);

        bout.write(dlzkaHry);
        bout.newLine();
        bout.write(obtiaznost);
        bout.newLine();
        bout.write(pozadie);
        bout.newLine();
        bout.write(lopta);
        bout.newLine();
        bout.write(odomknutePozadia);
        bout.newLine();
        bout.write(odomknuteLopty);
        bout.close();
    }
}
