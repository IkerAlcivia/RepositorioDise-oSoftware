
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import proyecto3.Tarea;


public class Operacion {

    private String nombre;
    private List<Tarea> tareas = new ArrayList<>();
    private List<Tarea> tareasIniciales = new ArrayList<>();

    public Operacion(String nombre) {
        this.nombre = nombre;
    }

    public void agregarTarea(Tarea tarea, boolean inicial) {
        tareas.add(tarea);
        if (inicial) {
            tareasIniciales.add(tarea);
        }
    }

    public void ejecutarTodas(ExecutorService executor) {
        // Ejecutar primero las tareas iniciales
        for (Tarea t : tareasIniciales) {
            executor.submit(t);
        }
        // Ejecutar el resto
        for (Tarea t : tareas) {
            if (!tareasIniciales.contains(t)) {
                executor.submit(t);
            }
        }
    }

    public void pausarTodas() {
        for (Tarea t : tareas) {
            t.pausar();
        }
    }

    public void reanudarTodas() {
        for (Tarea t : tareas) {
            t.reanudar();
        }
    }
}
