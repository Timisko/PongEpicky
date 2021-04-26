package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Settings implements Initializable {
    public ObservableList<String> obtiaznosti = FXCollections.observableArrayList("Ľahká", "Stredná", "Ťažká");
    public ObservableList<String> pozadia = FXCollections.observableArrayList("Čierna", "Futbal", "Basketbal", "Volejbal");
    public ObservableList<String> lopty = FXCollections.observableArrayList("Biela", "Futbal", "Basketbal", "Volejbal");
    public AnchorPane menu;
    public ComboBox<String> obtiaznostVyber;
    public ComboBox<String> pozadieVyber;
    public ComboBox<String> loptaVyber;

    String dlzkaHry;
    String obtiaznost;
    String pozadie;
    String lopta;

    public void load() throws IOException {
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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        obtiaznostVyber.setItems(obtiaznosti);
        pozadieVyber.setItems(pozadia);
        loptaVyber.setItems(lopty);
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    }

    public void setLopta(ActionEvent actionEvent) {

    }

    public void zapis() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("nastavenia.txt"));
        bw.write(dlzkaHry);
        bw.newLine();
        bw.write(obtiaznost);
        bw.close();
    }

    public void nastavDlzku5(ActionEvent actionEvent) {
        dlzkaHry = "5";
    }

    public void nastavDlzku10(ActionEvent actionEvent) {
        dlzkaHry = "10";
    }
}
