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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Settings implements Initializable {
    public ObservableList<String> obtiaznosti = FXCollections.observableArrayList("Ľahká","Stredná","Ťažká");
    public AnchorPane menu;
    public ComboBox<String> obtiaznostVyber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        obtiaznostVyber.setItems(obtiaznosti);
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("layout/menu.fxml"));
        menu.getChildren().setAll(pane);
    }

    public void setObtiaznost(ActionEvent actionEvent) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("nastavenia.txt"));

        switch (obtiaznostVyber.getValue()) {
            case "Ľahká" -> {
                bw.write("L");
            }
            case "Stredná" -> {
                bw.write("S");
            }
            case "Ťažká" -> {
                bw.write("T");
            }
        }

        bw.close();
    }


}
