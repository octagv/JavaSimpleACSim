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
    protected boolean horizontal;
    protected String nombre;
    protected ImageIcon imagen;
    public Celda(int x, int y, String nombre, ImageIcon imagen){
        this.posX = x;
        this.posY = y;
        this.nombre = nombre;
        this.imagen = imagen;
    }
}
