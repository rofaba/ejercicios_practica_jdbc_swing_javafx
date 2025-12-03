package org.example.demotablafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DetallePersonaView {

    @FXML
    private ImageView ivImagen;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblEdad;

    private Persona persona;

    @FXML
    private Label lblNombre;

    @FXML
    private Button btnSalir;

    public void initialize() {
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
        cargarDatos();
    }

    private void cargarDatos(){
        if(this.persona != null){
            lblNombre.setText(this.persona.getNombre());
            lblApellido.setText(this.persona.getApellido());
            lblEdad.setText(String.valueOf(this.persona.getEdad()));
            String url = persona.getImagen(); // tu campo de URL
            if (url != null && !url.isBlank()) {
                ivImagen.setImage(new Image(url, true));
            }
        }
    }
    //cerrar ventana o modal
    @FXML
    private void salir() {
        btnSalir.getScene().getWindow().hide();
    }
}
