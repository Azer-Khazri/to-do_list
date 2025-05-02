package com.example.todolist;

import com.example.todolist.Model.ItemList;
import com.example.todolist.Model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.time.LocalDate;

public class AddController {
    @FXML
    private TextField Description;

    @FXML
    private TextArea DetailsArea;

    @FXML
    private DatePicker Deadline;

    @FXML
    private ComboBox Categories;

    public void initialize() {
        Categories.getItems().setAll("In Progress","Someday","Important", "Waiting");
    }

    @FXML
    public void ok() {
        if(Deadline.getValue()==null || Description.getText().isEmpty()
                || DetailsArea.getText().isEmpty() || Categories.getValue() == null)
        {
            Alert dialog = new Alert(Alert.AlertType.NONE, "There was an error on your submission. Please retry!", ButtonType.OK);
            dialog.show();
        } else {
            String Category = Categories.getValue().toString();
            String shortDescription = Description.getText();
            String Details = DetailsArea.getText();
            LocalDate deadValue = Deadline.getValue();
            ItemList.getInstance().addItem(new Item(shortDescription, Details, Category, deadValue));
            close();
        }
    }

    @FXML
    public void cancel() {
        close();
    }

    private void close() {
        Stage stage = (Stage) Description.getScene().getWindow();
        stage.close();
    }
}