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
    private LinkedList<ItemComponente> componentes = new LinkedList();
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
    }
    //TODO: CAMBIAR ESTO
    public void agregarComponente(String nombre, int tipo, int valor){
        System.out.println("Se creo elemento");
        ItemComponente act = new ItemComponente(this.tablaComponentes, nombre, tipo, valor);
        this.componentes.add(act);
    }
    public ItemComponente obtenerPorNombre(String nombre){
        for(ItemComponente item : this.componentes){
            if(item.getNombre() == nombre){
                return item;
            }
        }
        return null;
    }
    
}
