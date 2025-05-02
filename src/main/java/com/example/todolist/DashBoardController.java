package com.example.todolist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class DashBoardController {
    @FXML
    private StackPane contentArea;

    public void initialize() throws IOException {
        todo();
    }

    @FXML
    public void todo() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("todo.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    public void config() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("config.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
}