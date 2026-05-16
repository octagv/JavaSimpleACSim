/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

/**
 *
 * @author Octav
 */
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ItemComponente {
    private JPanel padre;
    private JTextField campoNombre;
    private JTextField campoValor;
    private JComboBox campoTipo;
    //private AdministradorEjecucion admin;
    private int tipo;
    private double valor;
    private String nombre;
    
    private String s1[] = {"Resistencia", "Capacitor", "Inductor"};
    
    public ItemComponente(JPanel padre, String nombre, int tipo, int valor){
        this.padre = padre;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.agregar();
    }
    public void agregar(){
        campoNombre = new JTextField();
        campoNombre.setText(this.nombre);
        campoNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                actualizar();
            }
        });
        
        
        
        campoValor = new JTextField();
        campoValor.setText(String.valueOf(this.valor));
        campoValor.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {

                try {
                    double valorNuevo = Double.parseDouble(campoValor.getText());

                    if (valorNuevo < 0) {
                        throw new NumberFormatException();
                    }

                    System.out.println("Número válido: " + valorNuevo);
                    valor = valorNuevo;
                    actualizar();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese un número decimal positivo válido"
                    );

                    campoValor.requestFocus();
                }
            }
        });
        
        campoTipo = new JComboBox(s1);
        campoTipo.addActionListener(e -> {
            if (campoTipo.getSelectedItem() == "Resistencia"){
                this.tipo = 0;
            } else if (campoTipo.getSelectedItem() == "Capacitor"){
                this.tipo = 1;
            } else {
                this.tipo = 2;
            }
        actualizar();
        });
        
        this.padre.add(campoTipo);
        this.padre.add(campoNombre);
        this.padre.add(campoValor);
    }
    public void actualizar(){
        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public void setId(int id){
        this.tipo = id;
        this.campoTipo.setSelectedIndex(id);
    }
    
}
