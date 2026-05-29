/*   */
package mx.edu.uacm.is.ctl.ids.pixelcore.model;

import javafx.concurrent.Task;

public class MotorEjecucion {

    public static Task<Boolean> simularEjecucionTarea(Tarea tarea) {
        return new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                updateMessage("Validando precondiciones...");
                Thread.sleep(800); // Simulación de tiempo de carga

                int total = tarea.getInstrucciones().size();
                if (total == 0) {
                    updateMessage("Sin instrucciones de comportamiento.");
                    return true;
                }

                for (int i = 0; i < total; i++) {
                    if (isCancelled()) {
                        updateMessage("Operación Pausada/Detenida.");
                        return false;
                    }

                    String inst = tarea.getInstrucciones().get(i);
                    updateMessage("Ejecutando: " + inst);

                    
                    Thread.sleep(1500);// Simula el procesamiento asíncrono

                    
                    updateProgress(i + 1, total);// Actualiza barra JavaFX 
                }

                updateMessage("Tarea Finalizada con éxito.");
                return true;
            }
        };
    }
}
