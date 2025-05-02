module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.todolist to javafx.fxml;
    exports com.example.todolist;
    exports com.example.todolist.Model;
    opens com.example.todolist.Model to javafx.fxml;

}