package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Settings implements Initializable {
    public ObservableList<String> obtiaznosti = FXCollections.observableArrayList("Ľahká", "Stredná", "Ťažká");
    public ObservableList<String> pozadia;
    public ObservableList<String> lopty;
    public AnchorPane menu;
    public ComboBox<String> obtiaznostVyber;
    public ComboBox<String> pozadieVyber;
    public ComboBox<String> loptaVyber;

    String dlzkaHry;
    String obtiaznost;
    String pozadie;
    String lopta;
    String odomknutePozadia;
    String odomknuteLopty;

    public void citaj() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("nastavenia.txt"));

        dlzkaHry = br.readLine();

        obtiaznost = br.readLine();

        if (obtiaznost.equals("L")){
            obtiaznostVyber.setPromptText("Ľahká");
        }
        if (obtiaznost.equals("S")){
            obtiaznostVyber.setPromptText("Stredná");
        }
        if (obtiaznost.equals("T")){
            obtiaznostVyber.setPromptText("Ťažká");
        }

        pozadie = br.readLine();

        if (pozadie.equals("pC")){
            pozadieVyber.setPromptText("Čierna");
        }
        if (pozadie.equals("pF")){
            pozadieVyber.setPromptText("Futbal");
        }
        if (pozadie.equals("pB")){
            pozadieVyber.setPromptText("Basketbal");
        }
        if (pozadie.equals("pV")){
            pozadieVyber.setPromptText("Volejbal");
        }

        lopta = br.readLine();

        if (lopta.equals("lC")){
            loptaVyber.setPromptText("Biela");
        }
        if (lopta.equals("lF")){
            loptaVyber.setPromptText("Futbal");
        }
        if (lopta.equals("lB")){
            loptaVyber.setPromptText("Basketbal");
        }
        if (lopta.equals("lV")){
            loptaVyber.setPromptText("Volejbal");
        }

        odomknutePozadia = br.readLine();

        if (odomknutePozadia.equals("000")){
            pozadia = FXCollections.observableArrayList("Čierna");
        }
        if (odomknutePozadia.equals("100")){
            pozadia = FXCollections.observableArrayList("Čierna", "Futbal");
        }
        if (odomknutePozadia.equals("110")){
            pozadia = FXCollections.observableArrayList("Čierna", "Futbal", "Basketbal");
        }
        if (odomknutePozadia.equals("111")){
            pozadia = FXCollections.observableArrayList("Čierna", "Futbal", "Basketbal", "Volejbal");
        }
        if (odomknutePozadia.equals("010")){
            pozadia = FXCollections.observableArrayList("Čierna", "Basketbal");
        }
        if (odomknutePozadia.equals("011")){
            pozadia = FXCollections.observableArrayList("Čierna", "Basketbal", "Volejbal");
        }
        if (odomknutePozadia.equals("001")){
            pozadia = FXCollections.observableArrayList("Čierna", "Volejbal");
        }
        if (odomknutePozadia.equals("101")){
            pozadia = FXCollections.observableArrayList("Čierna", "Futbal", "Volejbal");
        }

        odomknuteLopty = br.readLine();

        if (odomknuteLopty.equals("000")){
            lopty = FXCollections.observableArrayList("Biela");
        }
        if (odomknuteLopty.equals("100")){
            lopty = FXCollections.observableArrayList("Biela", "Futbal");
        }
        if (odomknuteLopty.equals("110")){
            lopty = FXCollections.observableArrayList("Biela", "Futbal", "Basketbal");
        }
        if (odomknuteLopty.equals("111")){
            lopty = FXCollections.observableArrayList("Biela", "Futbal", "Basketbal", "Volejbal");
        }
        if (odomknuteLopty.equals("010")){
            lopty = FXCollections.observableArrayList("Biela", "Basketbal");
        }
        if (odomknuteLopty.equals("011")){
            lopty = FXCollections.observableArrayList("Biela", "Basketbal", "Volejbal");
        }
        if (odomknuteLopty.equals("001")){
            lopty = FXCollections.observableArrayList("Biela", "Volejbal");
        }
        if (odomknuteLopty.equals("101")){
            lopty = FXCollections.observableArrayList("Biela", "Futbal", "Volejbal");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            citaj();
        } catch (IOException e) {
            e.printStackTrace();
        }
        obtiaznostVyber.setItems(obtiaznosti);
        pozadieVyber.setItems(pozadia);
        loptaVyber.setItems(lopty);
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        zapis();
        BorderPane pane = FXMLLoader.load(getClass().getResource("layout/menu.fxml"));
        menu.getChildren().setAll(pane);
    }

    public void setObtiaznost(ActionEvent actionEvent){
        switch (obtiaznostVyber.getValue()) {
            case "Ľahká" -> {
                obtiaznost = "L";
            }
            case "Stredná" -> {
                obtiaznost = "S";
            }
            case "Ťažká" -> {
                obtiaznost = "T";
            }
        }
    }

    public void setPozadie(ActionEvent actionEvent) {
        switch (pozadieVyber.getValue()) {
            case "Čierna" -> {
                pozadie = "pC";
            }
            case "Futbal" -> {
                pozadie = "pF";
            }
            case "Basketbal" -> {
                pozadie = "pB";
            }
            case "Volejbal" -> {
                pozadie = "pV";
            }
        }
    }

    public void setLopta(ActionEvent actionEvent) {
        switch (loptaVyber.getValue()) {
            case "Biela" -> {
                lopta = "lC";
            }
            case "Futbal" -> {
                lopta = "lF";
            }
            case "Basketbal" -> {
                lopta = "lB";
            }
            case "Volejbal" -> {
                lopta = "lV";
            }
        }
    }

    public void zapis() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("nastavenia.txt"));
        bw.write(dlzkaHry);
        bw.newLine();

        bw.write(obtiaznost);
        bw.newLine();

        bw.write(pozadie);
        bw.newLine();

        bw.write(lopta);
        bw.newLine();

        bw.write(odomknutePozadia);
        bw.newLine();

        bw.write(odomknuteLopty);
        bw.close();
    }

    public void nastavDlzku5(ActionEvent actionEvent) {
        dlzkaHry = "5";
    }

    public void nastavDlzku10(ActionEvent actionEvent) {
        dlzkaHry = "10";
    }
}
