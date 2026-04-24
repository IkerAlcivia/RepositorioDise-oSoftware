/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.util.Scanner;
import modelo.GestorTareas;
import modelo.Operacion;
import modelo.Tarea;

/**
 *
 * @author David R
 */
public class GestorCode {
    
    public static void main(String[] args) {
        int numHilos = 6;
        GestorTareas gestor = new GestorTareas(numHilos);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de tareas con Operaciones iniciado.");
        System.out.println("Comandos disponibles: 'operacion', 'pausar', 'reanudar', 'salir'");

        while (true) {
            System.out.println("Ingrese comando:");
            String comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("salir")) {
                break;
            } else if (comando.equalsIgnoreCase("pausar")) {
                gestor.pausarTodas();
                System.out.println("Todas las tareas pausadas.");
            } else if (comando.equalsIgnoreCase("reanudar")) {
                gestor.reanudarTodas();
                System.out.println("Todas las tareas reanudadas.");
            } else if (comando.equalsIgnoreCase("operacion")) {
                System.out.println("Ingrese nombre de la Operacion:");
                String nombreOp = scanner.nextLine();

                Operacion operacion = new Operacion(nombreOp);

                while (true) {
                    System.out.println("Ingrese nombre de la tarea (o 'fin' para terminar esta Operacion):");
                    String nombreTarea = scanner.nextLine();
                    if (nombreTarea.equalsIgnoreCase("fin")) {
                        break;
                    }

                    System.out.println("Observacion:");
                    String obs = scanner.nextLine();

                    System.out.println("Duracion (segundos):");
                    int duracion = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer

                    System.out.println("Es tarea inicial? (s/n):");
                    boolean inicial = scanner.nextLine().equalsIgnoreCase("s");

                    Tarea tarea = new Tarea(nombreTarea, duracion, obs);
                    operacion.agregarTarea(tarea, inicial);
                }

                gestor.agregarOperacion(operacion);
                System.out.println("Operación '" + nombreOp + "' agregada y ejecutandose...");
            } else {
                System.out.println("Comando no reconocido. Usa: operacion, pausar, reanudar, salir");
            }
        }

        gestor.cerrar();
        System.out.println("Sistema finalizado.");
    }
    
}
