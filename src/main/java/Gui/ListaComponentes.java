/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;


import javax.swing.BoxLayout;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
/**
 *
 * @author Octav
 */
public class ListaComponentes extends JPanel {
    public ListaComponentes() {
        super();
        LayoutManager layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(layout);
        this.add(new JLabel("Componentes:"));
        this.add(new JTable(10,2));
    }
    
}
