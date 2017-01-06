/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new UsersPanel(), 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
