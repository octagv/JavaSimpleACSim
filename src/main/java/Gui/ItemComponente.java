/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

/**
 *
 * @author Octav
 */
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ItemComponente {
    private char tipo;
    private double valor;
    private String nombre;
    private JPanel padre;
    private String s1[] = {"Resistencia", "Capacitor", "Inductor"};
    
    public ItemComponente(JPanel padre){
        this.tipo = 'R';
        this.valor = 0;
        this.nombre = "null";
        this.padre = padre;
    }
    public void agregar(){
        this.padre.add(new JComboBox(s1));
        this.padre.add(new JTextField());
        this.padre.add(new JTextField());
    }
}
