package pl.sdk.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {


    public Start() {
//        GameEngine game = new GameEngine(new ArrayList<>(), new ArrayList<>());
//        game.move(new Point(1,1 ), new Point(5,5));
    }

    @Override
    public void start(Stage aStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("fxml/chessboard.fxml")));

        aStage.setScene(scene);
        aStage.setX(100);
        aStage.setY(100);
        aStage.show();
    }
}
