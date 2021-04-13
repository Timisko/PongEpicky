package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {
    public Parent root;

    public int peniaze = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("layout/sample.fxml"));
        primaryStage.setTitle("Pong");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("res/volleyball.png")));
        primaryStage.show();

        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        break;
                    case DOWN:
                        break;
                    case W:
                        Game.PosY = -4;
                        break;
                    case S:
                        Game.PosY = 4;
                        break;
                }
            }
        });
        scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        break;
                    case DOWN:
                        break;
                    case W:
                    case S:
                        Game.PosY = 0;
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
