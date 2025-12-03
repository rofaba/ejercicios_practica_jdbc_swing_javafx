package org.example.demotablafx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button btnAgregar;

    @FXML
    private TableColumn colApellido;

    @FXML
    private TableColumn colEdad;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colImagen;

    @FXML
    private TableView<Persona> tblPersona;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtImagen;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private ImageView imageView;


    @FXML
    private ObservableList<Persona> listaPersonas;

    public void initialize() {
        listaPersonas = FXCollections.observableArrayList();
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("edad"));
        // Esto dice de dónde sacar la URL
        colImagen.setCellValueFactory(new PropertyValueFactory<>("imagen"));

        // Esto dice CÓMO pintar esa URL (como imagen, no como texto)
        colImagen.setCellFactory(col -> new TableCell<Persona, String>() {

            private final ImageView imageView = new ImageView();

            {
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                imageView.setPreserveRatio(true);
            }

            @Override
            protected void updateItem(String url, boolean empty) {
                super.updateItem(url, empty);

                if (empty || url == null || url.isBlank()) {
                    setGraphic(null);
                } else {
                    imageView.setImage(new Image(url, true)); // URL de internet o file:
                    setGraphic(imageView);                    // ponemos la imagen en la celda
                }
            }
        });
    }

    @FXML
    void agregarPersona() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String imagen = String.valueOf(txtImagen.getText());

        Persona p = new Persona(nombre, apellido, edad, imagen);

        try {
            if (!this.listaPersonas.contains(p)) {
                this.listaPersonas.add(p);
                this.tblPersona.setItems(listaPersonas);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText(null);
                alert.setContentText("La persona ya existe en la lista.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
        }

        txtNombre.clear();
        txtApellido.clear();
        txtEdad.clear();
    }

    @FXML
    void seleccionar() {
        Persona p = this.tblPersona.getSelectionModel().getSelectedItem();
        if (p != null) {
            this.txtNombre.setText(p.getNombre());
            this.txtApellido.setText(p.getApellido());
            this.txtEdad.setText(String.valueOf(p.getEdad()));
            this.txtImagen.setText(p.getImagen());
        }

    }

    @FXML
    void modificar() {
        Persona p = this.tblPersona.getSelectionModel().getSelectedItem();
        if (p != null) {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setEdad(edad);

            this.tblPersona.refresh();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione una persona para modificar.");
            alert.showAndWait();
        }
    }

    @FXML
    void eliminar() {
        Persona p = this.tblPersona.getSelectionModel().getSelectedItem();
        if (p != null) {
            this.listaPersonas.remove(p);
            this.tblPersona.setItems(listaPersonas);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione una persona para eliminar.");
            alert.showAndWait();
        }
    }

    private void abrirDetalle(Persona persona) {
        if (persona == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione una persona para ver el detalle.");
            alert.showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detalle-persona-view.fxml"));

            // 1) PRIMERO cargar el FXML
            Parent root = loader.load();

            // 2) DESPUÉS obtener el controller
            DetallePersonaView detalleController = loader.getController();
            detalleController.setPersona(persona);

            Stage stage = new Stage();
            stage.setTitle("Detalle de Persona");
            stage.setScene(new Scene(root));
            stage.initOwner(tblPersona.getScene().getWindow());
            stage.show();

        } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No se pudo cargar la información de la persona.");
                alert.showAndWait();
            }
        }


    @FXML
    private void verDetalle() {
        Persona seleccionada = tblPersona.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione una persona para ver el detalle.");
            alert.showAndWait();

        }else {
            abrirDetalle(seleccionada);
        }
    }

}
