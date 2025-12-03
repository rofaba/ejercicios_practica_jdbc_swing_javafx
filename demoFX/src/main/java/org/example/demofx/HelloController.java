package org.example.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private TextField txtOpe1;
    @FXML
    private TextField txtOpe2;
    @FXML
    private TextField txtResult;
    @FXML
    private Button btnCalcular;
    @FXML
    private RadioButton rbSumar;
    @FXML
    private RadioButton rbRestar;
    @FXML
    private RadioButton rbMultiplicar;
    @FXML
    private RadioButton rbDividir;

    @FXML
    public void initialize() {
        ToggleGroup group = new ToggleGroup();
        rbSumar.setToggleGroup(group);
        rbRestar.setToggleGroup(group);
        rbMultiplicar.setToggleGroup(group);
        rbDividir.setToggleGroup(group);
        rbSumar.setSelected(true);
    }

    @FXML
    protected void calcular(ActionEvent event) {
        try {
            int ope1 = Integer.parseInt(txtOpe1.getText());
            int ope2 = Integer.parseInt(txtOpe2.getText());

            Operacion op = new Operacion(ope1, ope2);
            if (rbSumar.isSelected()) {
                int resultado = op.sumar(ope1, ope2);
                txtResult.setText(String.valueOf(resultado));
                } else if (rbRestar.isSelected()){
                int resultado = op.restar(ope1, ope2);
                txtResult.setText(String.valueOf(resultado));
                } else if (rbMultiplicar.isSelected()){
                int resultado = op.multiplicar(ope1, ope2);
                txtResult.setText(String.valueOf(resultado));
                } else if (rbDividir.isSelected()){
                if (ope2 == 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error de división");
                    alert.setContentText("No se puede dividir entre cero.");
                    alert.showAndWait();
                    }
                double resultado = op.dividir(ope1, ope2);
                txtResult.setText(String.valueOf(resultado));
                }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de entrada");
            alert.setContentText("Por favor, ingrese números enteros válidos.");
            alert.showAndWait();
        }
    }
}