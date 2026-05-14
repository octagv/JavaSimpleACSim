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
    private int posX = 0;
    private int posY = 0;
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
    
    //Para evitar que la celda sea editable
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
