/*  */
package mx.edu.uacm.is.ctl.ids.pixelcore.model;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.StringProperty;

public class Tarea {

    private final String id;
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty estado = new SimpleStringProperty("NO_EJECUTADA");

    private final List<String> precondiciones = new ArrayList<>(); //lista interna
    private final List<String> postcondiciones = new ArrayList<>();
    private final List<String> instrucciones = new ArrayList<>();

    
    public Tarea(String id, String nombre) {
        this.id = id;
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty estadoProperty() {
        return estado;
    }

    public String getId() {
        return id;
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

    public List<String> getPrecondiciones() {
        return precondiciones;
    }

    public List<String> getPostcondiciones() {
        return postcondiciones;
    }

    public List<String> getInstrucciones() {
        return instrucciones;
    }

    @Override
    public String toString() {
        return getNombre() + " (" + getEstado() + ")";
    }

}
