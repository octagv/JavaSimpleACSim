/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.io.Serializable;
import java.util.LinkedList;
/**
 *
 * @author Octav
 */
public class Almacenador implements Serializable {
    private LinkedList<String> graficos;
    private LinkedList<String> circuito;
    
    public Almacenador(){
        this.graficos = new LinkedList();
        this.circuito = new LinkedList();
    }
    public void vaciar() {
        this.graficos.clear();
        this.circuito.clear();
    }
    public void agregarLineaComponente(String linea){
        this.circuito.add(linea);
    }
    public void agregarLineaGrafico(String linea){
        this.graficos.add(linea);
    }
}
