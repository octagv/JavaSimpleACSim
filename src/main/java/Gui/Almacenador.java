/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
/**
 *
 * @author Octav
 */
public class Almacenador implements Serializable {
    protected LinkedList<String> graficos;
    protected LinkedList<String> circuito;
    protected String nombreArchivo;
    
    public Almacenador(){
        this.graficos = new LinkedList();
        this.circuito = new LinkedList();
        this.nombreArchivo = "";
    }
    public void vaciar() {
        this.nombreArchivo = "";
        this.graficos.clear();
        this.circuito.clear();
    }
    public void agregarLineaComponente(String linea){
        this.circuito.add(linea);
    }
    public void agregarLineaGrafico(String linea){
        this.graficos.add(linea);
    }
    
    public void abrirArchivo(){
        try {
            FileInputStream file = new FileInputStream(this.nombreArchivo);
            ObjectInputStream is = new ObjectInputStream(file);
            Almacenador aux = (Almacenador)is.readObject();
            this.circuito = aux.circuito;
            this.graficos = aux.graficos;
            is.close();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error Garrafal");
        }
    }
    public void guardarArchivo(){
        try{
            FileOutputStream file = new FileOutputStream(this.nombreArchivo);
            ObjectOutputStream os = new ObjectOutputStream(file);
            os.writeObject(this);
            os.close();
        } catch (IOException e) {
            System.out.println("Error Garrafal");
        }
    }
}
