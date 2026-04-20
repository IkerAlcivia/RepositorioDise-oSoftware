/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uacm.is.slt.ds.gestorcode.opercion;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author David R
 */
public class Operacion {
    private String nombre;
    private List<Tarea> listaTareas = new ArrayList<>();
    private List<Tarea> tareasIniciales = new ArrayList<>();
    
    public Operacion(String nombre){
        this.nombre = nombre;
    }
    
    public void agregarTarea(Tarea tarea, boolean inicial){
        listaTareas.add(tarea);
        if(inicial){
            tareasIniciales.add(tarea);
        }
    }
    
    public void IniciarTareas(ExecutorService iniciar){
        for(int i = 0; i < tareasIniciales.size(); i++){
            Tarea tarea = tareasIniciales.get(i);
            iniciar.submit(tarea);
        }
        
        for(int i = 0; i < listaTareas.sisze(); i++){
            Tarea tarea = listaTareas.get(i);
            if(!tareasIniciales.contains(tarea)){
                iniciar.sumbit(tarea);
            }
        }
        
    }
    
    public void pausarTareas(){
        for(int i = 0; i < listaTareas; i++){
            Tarea tarea = listaTareas.get(i);
            tarea.pausar();
        }
    }
    
    public void reanudarTareas(){
        for(int i = 0; i <listaTareas.size(); i++){
            Tarea tarea = listaTareas.get(i);
            tarea.reanudar();
        }
    }
    
    
    
}
