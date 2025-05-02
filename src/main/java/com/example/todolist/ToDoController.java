package com.example.todolist;

import com.example.todolist.Model.ItemList;
import com.example.todolist.Model.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class ToDoController {
    @FXML
    private ListView<Item> todos;

    @FXML
    private Label deadlineLabel;

    public void initialize() {
        todos.setItems(ItemList.getInstance().getItems());
    }

    @FXML
    void Addnew() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void onItemClicked() {
        Item item = todos.getSelectionModel().getSelectedItem();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM yyyy");
        deadlineLabel.setText(df.format(item.getDeadline()));
    }
}