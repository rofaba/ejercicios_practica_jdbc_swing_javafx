module org.example.demoagenda {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demoagenda to javafx.fxml;
    exports org.example.demoagenda;
}