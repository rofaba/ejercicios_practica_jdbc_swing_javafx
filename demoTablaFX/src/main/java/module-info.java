module org.example.demotablafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.demotablafx to javafx.fxml;
    exports org.example.demotablafx;
}