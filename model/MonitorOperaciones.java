/*  */
package mx.edu.uacm.is.ctl.ids.pixelcore.model;

import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class MonitorOperaciones {

    private final ObservableList<Operacion> listaMaestra = FXCollections.observableArrayList(); //lista general

    private final SortedList<Operacion> operacionesOrdenadas;//lista ordenada

    private static final Map<String, Integer> MATRIZ_PRIORIDAD = Map.of( //elementos estaticos
            "EN_EJECUCION", 1,
            "PAUSADA", 2,
            "DETENIDA", 3,
            "NO_EJECUTADA", 4,
            "FINALIZADA", 5
    );

    public MonitorOperaciones(SortedList<Operacion> operacionesOrdenadas) {//constructor vacio
        this.operacionesOrdenadas = operacionesOrdenadas;
    }

    public MonitorOperaciones() { //constructor con parametros

        this.operacionesOrdenadas = new SortedList<>(listaMaestra, (op1, op2) -> {
            int peso1 = MATRIZ_PRIORIDAD.getOrDefault(op1.getEstado(), 99);
            int peso2 = MATRIZ_PRIORIDAD.getOrDefault(op2.getEstado(), 99);

            if (peso1 == peso2) { //si son iguales se ordenan
                return op1.getNombre().compareToIgnoreCase(op2.getNombre());
            }
            return Integer.compare(peso1, peso2);
        });
    }

    public void registrarOperacion(Operacion op) { //posicion en la lista
        this.listaMaestra.add(op);
    }

    public SortedList<Operacion> getOperacionesOrdenadas() { //imprime lalista
        return operacionesOrdenadas;
    }

}
