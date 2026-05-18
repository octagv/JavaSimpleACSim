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
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
    
    public ItemComponente(JPanel padre, String nombre, int tipo, double valor){
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
                String comparador = "^[A-Za-z][^\\s]*$";
                if(campoNombre.getText().matches(comparador)){
                    actualizar();
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese un nombre valido(Que empieze por una letra y que no contenga espacios)"
                    );

                    campoNombre.requestFocus();
                    campoNombre.selectAll();
                }
                
            }
        });
        campoNombre.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String comparador = "^[A-Za-z][^\\s]*$";
                JTextField campo = (JTextField) input;
                if(campo.getText().matches(comparador)){
                    actualizar();
                    return true;
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese un nombre valido(Que empieze por una letra y que no contenga espacios)"
                    );
                    campo.selectAll();
                    return false;
                }
            }
        });
        
        
        
        campoValor = new JTextField();
        campoValor.setText(String.valueOf(this.valor));
        campoValor.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField campo = (JTextField) input;
                try {
                    double valorNuevo = Double.parseDouble(campo.getText());
                    if (valorNuevo < 0) {
                        throw new NumberFormatException();
                    }
                    valor = valorNuevo;
                    actualizar();
                    return true;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese un número decimal positivo válido"
                    );
                    campo.selectAll();
                    return false;
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
