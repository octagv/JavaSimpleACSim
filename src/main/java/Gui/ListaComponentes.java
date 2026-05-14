/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.util.LinkedList;
/**
 *
 * @author Octav
 */
public class ListaComponentes extends JPanel {
    private LinkedList componentes = new LinkedList<ItemComponente>();
    private JPanel tablaComponentes;
    public ListaComponentes() {
        super();
        this.setLayout(new BorderLayout());
        this.tablaComponentes = new JPanel(new GridLayout(0,3));
        this.tablaComponentes.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.tablaComponentes.add(new JLabel("Tipo"));
        this.tablaComponentes.add(new JLabel("Nombre"));
        this.tablaComponentes.add(new JLabel("Valor"));
        this.add(new JLabel("Componentes:"), BorderLayout.NORTH);
        this.add(this.tablaComponentes, BorderLayout.NORTH);
        for (int i = 0; i < 10; i++){
            this.agregarComponente();
        }
    }
    //TODO: CAMBIAR ESTO
    public void agregarComponente(){
        ItemComponente act = new ItemComponente(this.tablaComponentes);
        this.componentes.add(act);
        act.agregar();
    }
    
}
