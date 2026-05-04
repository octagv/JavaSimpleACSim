/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 *
 * @author Octav
 */

public class Canvas extends JTable {
    private int nroCeldas = 50;
    private int tamanhoCeldas = 60;
    public Canvas(){
        super(50, 50);    
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setRowHeight(this.tamanhoCeldas);
        for(int i=0; i<this.nroCeldas;i++) {
                this.getColumnModel().getColumn(i).setPreferredWidth(this.tamanhoCeldas);
        }
    }
}
