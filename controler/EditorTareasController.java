
/*   */
package mx.edu.uacm.is.ctl.ids.pixelcore.controler;

import mx.edu.uacm.is.ctl.ids.pixelcore.model.Tarea;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditorTareasController {

    @FXML
    private ListView<Tarea> listaTareasUI;
    @FXML
    private TextField txtNombreTarea;
    @FXML
    private TextArea txtPrecondiciones;
    @FXML
    private TextArea txtPostcondiciones;
    @FXML
    private TextArea txtInstrucciones;
    @FXML
    private Button btnGuardarCambios;

    private Tarea tareaSeleccionada;

    @FXML
    public void initialize() {
     
        listaTareasUI.getSelectionModel().selectedItemProperty()
                .addListener((observable, viejaTarea, nuevaTarea) -> {//selecciona espacio
            if (nuevaTarea != null) {
                cargarTareaEnEditor(nuevaTarea);
            }
        });
        configurarEstadoEditor(true);
    }

    private void cargarTareaEnEditor(Tarea tarea) {
        this.tareaSeleccionada = tarea;
        txtNombreTarea.setText(tarea.getNombre());
        txtPrecondiciones.setText(String.join("\n",
                tarea.getPrecondiciones()));
        txtPostcondiciones.setText(String.join("\n",
                tarea.getPostcondiciones()));
        txtInstrucciones.setText(String.join("\n",
                tarea.getInstrucciones()));

        configurarEstadoEditor(false);
    }

    @FXML
    private void guardarCambiosTarea() {
        if (tareaSeleccionada == null) {
            return;
        }

        tareaSeleccionada.nombreProperty().set(txtNombreTarea.getText());

        // Procesar Precondiciones
        tareaSeleccionada.getPrecondiciones().clear();
        for (String p : txtPrecondiciones.getText().split("\n")) {
            if (!p.trim().isEmpty()) {
                tareaSeleccionada.getPrecondiciones().add(p.trim());
            }
        }

        // Procesar Postcondiciones
        tareaSeleccionada.getPostcondiciones().clear();
        for (String p : txtPostcondiciones.getText().split("\n")) {
            if (!p.trim().isEmpty()) {
                tareaSeleccionada.getPostcondiciones().add(p.trim());
            }
        }

        // Procesar Instrucciones de Comportamiento
        tareaSeleccionada.getInstrucciones().clear();
        for (String ins : txtInstrucciones.getText().split("\n")) {
            if (!ins.trim().isEmpty()) {
                tareaSeleccionada.getInstrucciones().add(ins.trim());
            }
        }

        System.out.println("Cambios aplicados a la tarea: " 
                            + tareaSeleccionada.getNombre());
        listaTareasUI.refresh(); // Refresca el texto en la interfaz gráfica
    }

    private void configurarEstadoEditor(boolean deshabilitado) {
        txtNombreTarea.setDisable(deshabilitado);
        txtPrecondiciones.setDisable(deshabilitado);
        txtPostcondiciones.setDisable(deshabilitado);
        txtInstrucciones.setDisable(deshabilitado);
        btnGuardarCambios.setDisable(deshabilitado);
    }

    public void setTareasTarget(javafx.collections.ObservableList<Tarea> tareas) {
        this.listaTareasUI.setItems(tareas);
    }

}
