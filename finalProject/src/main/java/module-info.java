module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.finalproject to javafx.fxml;
    //exports com.example.finalproject;
    exports com.example.finalproject.GUI;
    opens com.example.finalproject.GUI to javafx.fxml;
}