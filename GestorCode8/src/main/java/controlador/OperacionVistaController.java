/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mx.edu.uacm.ise.slt.ds.gestorcode;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author David R
 */
public class OperacionVistaController implements Initializable {

    @FXML
    private Label lblNomTar;
    @FXML
    private TextField txtNomTar;
    @FXML
    private Label lblTipoTarea;
    @FXML
    private CheckBox checkBoxTareaInicial;
    @FXML
    private CheckBox checkBoxTareaFinal;
    @FXML
    private Button btnRegistar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnMenu;
    @FXML
    private Label lblNombreOper;
    @FXML
    private TextField txtNombreOper;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RegistrarOperacion(ActionEvent event) {
    }

    @FXML
    private void Limpiar(ActionEvent event) {
    }

    @FXML
    private void regresoMenu(ActionEvent event) {
    }
    
}
