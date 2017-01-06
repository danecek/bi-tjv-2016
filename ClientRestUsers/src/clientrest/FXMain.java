package clientrest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new UsersPanel(), 300, 250);
        primaryStage.setTitle("Users");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}