import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import proyecto3.Tarea;


public class GestorTareas {
    private ExecutorService executor;
    private List<Operacion> operaciones = new ArrayList<>();

    public GestorTareas(int numHilos) {
        executor = Executors.newFixedThreadPool(numHilos);
    }

    public void agregarOperacion(Operacion op) {
        operaciones.add(op);
        op.ejecutarTodas(executor);
    }

    public void pausarTodas() {
        for (Operacion op : operaciones) {
            op.pausarTodas();
        }
    }

    public void reanudarTodas() {
        for (Operacion op : operaciones) {
            op.reanudarTodas();
        }
    }

    public void cerrar() {
        executor.shutdown();
    }
}