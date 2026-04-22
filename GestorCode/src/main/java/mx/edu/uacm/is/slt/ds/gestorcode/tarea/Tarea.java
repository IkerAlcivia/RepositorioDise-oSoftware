package proyecto3;

public class Tarea implements Runnable {

     private String nombre;
     String obs;
    private int duracion;

    private volatile boolean pausado = false;
    private final Object lock = new Object();

    public Tarea(String nombre, int duracion,String obs) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.obs = obs;
    }

    @Override
    public void run() {
        for (int i = 0; i < duracion; i++) {

            // Punto de pausa
            synchronized (lock) {
                while (pausado) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            System.out.println(nombre + " ejecutando paso " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(nombre + " terminada");
    }

    public void pausar() {
        pausado = true;
    }

    public void reanudar() {
        synchronized (lock) {
            pausado = false;
            lock.notifyAll();
        }
    }
}