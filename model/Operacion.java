/*   */
package mx.edu.uacm.is.ctl.ids.pixelcore.model;

import javafx.collections.FXCollections;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Operacion {

    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty estado = new SimpleStringProperty("NO_EJECUTADA");
    private final ObservableList<Tarea> tareas = FXCollections.observableArrayList();

    public void setTargetEstadoNoEjecutada() { 
        this.setEstado("NO_EJECUTADA"); 
    }
    
    public Operacion() {//constructor vacio
    }

    public Operacion(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty estadoProperty() {
        return estado;
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String nuevoEstado) {
        this.estado.set(nuevoEstado);
    }

    public ObservableList<Tarea> getTareas() {
        return tareas;
    }
     
}
