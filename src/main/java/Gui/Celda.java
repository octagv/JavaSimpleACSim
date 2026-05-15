/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Octav
 */
public class Celda {
    protected int posX;
    protected int posY;
    protected int id;
    protected String nombre;
    protected ImageIcon imagen;
    
    private static ImageIcon[] IMAGENES = {
        new ImageIcon("imagenes/resistencia.png"),
        new ImageIcon("imagenes/capacitor.png"),
        new ImageIcon("imagenes/inductor.png"),
        new ImageIcon("imagenes/fuenteCorriente.png"),
        new ImageIcon("imagenes/fuenteVoltaje.png"),
        new ImageIcon("imagenes/cableHorizontal.png"),
        new ImageIcon("imagenes/cableVertical.png"),
        new ImageIcon("imagenes/esquinaArribaIzquierda.png"),
        new ImageIcon("imagenes/esquinaArribaDerecha.png"),
        new ImageIcon("imagenes/esquinaAbajoIzquierda.png"),
        new ImageIcon("imagenes/esquinaAbajoDerecha.png"),
        new ImageIcon("imagenes/tSuperior.png"),
        new ImageIcon("imagenes/tInferior.png"),
        new ImageIcon("imagenes/tDerecha.png"),
        new ImageIcon("imagenes/tIzquierda.png"),
        new ImageIcon("imagenes/cruz.png"),
    };
    
    public Celda(int x, int y, String nombre, int idImg){
        this.posX = x;
        this.posY = y;
        this.id = idImg;
        this.nombre = nombre;
        this.imagen = IMAGENES[idImg];
    }
    public void setId(int idImg){
        this.id = idImg;
        this.imagen = IMAGENES[idImg];
    }
    public boolean esComponente(){
        return (this.id < 3);
    }
    public String getLinea(){
        String linea = String.valueOf(this.id) + " " + String.valueOf(this.posX) + " " + String.valueOf(this.posY);
        if (this.esComponente()){
            linea += " " + this.nombre;
        }
        return linea;
    }
    public static Celda desdeString(String dato){
        String[] datos = dato.split(" ");
        return new Celda(Integer.parseInt(datos[1]),Integer.parseInt(datos[2]),"", Integer.parseInt(datos[0]));
    }
    public static Celda ComponentedesdeString(String dato, String nombre){
        String[] datos = dato.split(" ");
        return new Celda(Integer.parseInt(datos[1]),Integer.parseInt(datos[2]),nombre, Integer.parseInt(datos[0]));
    }
}
