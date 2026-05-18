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
    protected LinkedList<ItemComponente> componentes = new LinkedList();
    private JPanel tablaComponentes;
    public ListaComponentes() {
        super();
        this.setLayout(new BorderLayout());
        this.tablaComponentes = new JPanel(new GridLayout(0,3));
        this.tablaComponentes.setBorder(new EmptyBorder(10, 10, 10, 10));
        tablaComponentes.add(new JLabel("Componentes:"));
        tablaComponentes.add(new JLabel(" "));
        tablaComponentes.add(new JLabel(" "));
        this.tablaComponentes.add(new JLabel("Tipo"));
        this.tablaComponentes.add(new JLabel("Nombre"));
        this.tablaComponentes.add(new JLabel("Valor"));
        this.add(this.tablaComponentes, BorderLayout.NORTH);
    }
    //TODO: CAMBIAR ESTO
    public ItemComponente agregarComponente(String nombre, int tipo, double valor){
        System.out.println("Se creo elemento");
        ItemComponente act = new ItemComponente(this.tablaComponentes, nombre, tipo, valor);
        this.componentes.add(act);
        tablaComponentes.revalidate();
        tablaComponentes.repaint();
        return act;
    }
    public ItemComponente obtenerPorNombre(String nombre){
        for(ItemComponente item : this.componentes){
            if(item.getNombre().equals(nombre)){
                return item;
            }
        }
        return null;
    }  
    
    public void renombrarItem(String nombre, String nombreNuevo){
        for(ItemComponente item : this.componentes){
            if(item.getNombre().equals(nombre)){
                item.setNombre(nombreNuevo);
            }
        }
    }
    public void vaciar() {
        componentes.clear();

        tablaComponentes.removeAll();
        tablaComponentes.add(new JLabel("Componentes:"));
        tablaComponentes.add(new JLabel(" "));
        tablaComponentes.add(new JLabel(" "));
        tablaComponentes.add(new JLabel("Tipo"));
        tablaComponentes.add(new JLabel("Nombre"));
        tablaComponentes.add(new JLabel("Valor"));

        tablaComponentes.revalidate();
        tablaComponentes.repaint();
    }
    
}
