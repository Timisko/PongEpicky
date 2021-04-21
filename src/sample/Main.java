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

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("layout/menu.fxml"));
        primaryStage.setTitle("Pong");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("res/ikona.png")));
        primaryStage.show();

        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        VersusGame.Pos2Y = -4;
                        break;
                    case DOWN:
                        VersusGame.Pos2Y = 4;
                        break;
                    case W:
                        Game.PosY = -4;
                        VersusGame.Pos1Y = -4;
                        break;
                    case S:
                        Game.PosY = 4;
                        VersusGame.Pos1Y = 4;
                        break;
                }
            }
        });
        scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                    case DOWN:
                        VersusGame.Pos2Y = 0;
                        break;
                    case W:
                    case S:
                        Game.PosY = 0;
                        VersusGame.Pos1Y = 0;
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
