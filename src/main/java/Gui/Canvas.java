/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableCellRenderer;

 /*
 * @author Octav
 */

public class Canvas extends JTable {
    private int nroCeldas = 50;
    private int tamanhoCeldas = 60;
    protected int posX = 0;
    protected int posY = 0;
    public Canvas(){
        super(50, 50);    
        this.setCellSelectionEnabled(true);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setRowHeight(this.tamanhoCeldas);
        for(int i=0; i<this.nroCeldas;i++) {
                this.getColumnModel().getColumn(i).setPreferredWidth(this.tamanhoCeldas);
        }

        this.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                this.posY = this.getSelectedRow();
                this.posX = this.getSelectedColumn();

                //System.out.println("X: " + posX);
                //System.out.println("Y: " + posY);
            }
        });

        this.getColumnModel().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                this.posY = this.getSelectedRow();
                this.posX = this.getSelectedColumn();

                //System.out.println("X: " + posX);
                //System.out.println("Y: " + posY);
            }
        });this.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                this.posY = this.getSelectedRow();
                this.posX = this.getSelectedColumn();

                //System.out.println("X: " + posX);
               //System.out.println("Y: " + posY);
            }
        });

        this.getColumnModel().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                this.posY = this.getSelectedRow();
                this.posX = this.getSelectedColumn();

                //System.out.println("X: " + posX);
                //System.out.println("Y: " + posY);
            }
        });
        //Colocar Renderizador
        this.setDefaultRenderer(Object.class, new CeldaRenderer());

    }
    
    public void agregarCelda(Celda celda, int x, int y){
        
        this.setValueAt(celda, x, y);
    }
    public void eliminarCelda(int x, int y){
        
        this.setValueAt(null, x, y);
    }
    public Celda obtenerCelda(int x, int y) {
        return (Celda) this.getValueAt(x, y);
    }
    public Celda obtenerCeldaActual() {
        return (Celda) this.getValueAt(this.posY, this.posX);
    }
    
    //Para evitar que la celda sea editable
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
