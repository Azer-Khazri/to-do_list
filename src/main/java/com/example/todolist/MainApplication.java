package com.example.todolist;

import com.example.todolist.Model.ItemList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void init() throws Exception {
        ItemList.getInstance().loadItems();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        primaryStage.setScene(new Scene(root, 1000, 664));
        primaryStage.setTitle("ToDo App");
        primaryStage.show();
    }

    @Override
    public void stop() throws IOException{
        ItemList.getInstance().storeItems();
    }

    public static void main(String[] args) {
        launch();
    }
}