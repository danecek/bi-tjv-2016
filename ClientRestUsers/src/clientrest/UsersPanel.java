/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrest;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.User;

public class UsersPanel extends VBox {

    public UsersPanel() {
        List<User> all = Proxy.instance.all();
        ObservableList<User> ol = FXCollections.observableArrayList(all);
        Button addButton = new Button("Add");
        TextField nameField = new TextField();
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Proxy.instance.add(nameField.getText());
                ol.setAll(Proxy.instance.all());
            }
        });
        getChildren().addAll(new ListView<>(ol),
                new HBox(new Label("Name:"), nameField, addButton));
    }

}
