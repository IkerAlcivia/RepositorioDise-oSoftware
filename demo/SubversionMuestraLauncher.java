/*   */
package mx.edu.uacm.is.ctl.ids.pixelcore.demo;

import mx.edu.uacm.is.ctl.ids.pixelcore.model.MonitorOperaciones;
import mx.edu.uacm.is.ctl.ids.pixelcore.model.Operacion;
import mx.edu.uacm.is.ctl.ids.pixelcore.model.Tarea;

public class SubversionMuestraLauncher {
    
    public static void cargarEscenarioPrueba(MonitorOperaciones monitor) {
        
        Operacion opDemo = new Operacion("Análisis de Riesgo Firewall");
        opDemo.setTargetEstadoNoEjecutada(); // Estado inicial neutro//Operación muestra
        
        Tarea t1 = new Tarea("SEC-01", "Escaneo de Puertos IP de Red");// ejecucion sin dependencias)
        t1.getPrecondiciones().add("Interfaz de red eth0 en modo promiscuo");
        t1.getInstrucciones().add("Lanzar peticiones SYN estructuradas");
        t1.getInstrucciones().add("Filtrar respuestas RST/ACK recibidas");
        t1.getPostcondiciones().add("Mapa de puertos abiertos generado");

        Tarea t2 = new Tarea("SEC-02", "Auditoría de Firmas de Malware");//Ejecución independiente
        t2.getPrecondiciones().add("Base de datos de firmas actualizada localmente");
        t2.getInstrucciones().add("Calcular hashes criptográficos MD5 de binarios");
        t2.getInstrucciones().add("Cruzar hashes contra lista negra conocida");
        t2.getPostcondiciones().add("Reporte de integridad de archivos completado");

        Tarea t3 = new Tarea("SEC-03", "Aislamiento Automático de Host");//ejecucion secuencial
        t3.getPrecondiciones().add("Al menos un puerto vulnerable identificado en SEC-01");
        t3.getInstrucciones().add("Inyectar regla DROP en tablas de Netfilter iptables");
        t3.getInstrucciones().add("Notificar al módulo de contingencia central");
        t3.getPostcondiciones().add("Dirección IP atacante bloqueada con éxito");

        opDemo.getTareas().addAll(t1, t2, t3);//lista operación demo

        monitor.registrarOperacion(opDemo); //monitor dinámico

        Operacion opHistorial = new Operacion("Mantenimiento Rutinario de Servidor");// Simulación 
        opHistorial.setEstado("FINALIZADA");
        monitor.registrarOperacion(opHistorial);
    }

}
