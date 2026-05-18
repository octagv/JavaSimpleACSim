/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

/**
 *
 * @author Octav
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


import javax.swing.border.EmptyBorder;

public class ConfiguradorFuente extends JPanel {
    private char tipo;
    private double valor;
    private double frecuencia;
    private double desfase;
    private JTextField[] campos = {null, null, null};
    public ConfiguradorFuente() {
        super();
        this.tipo = 'V';
        this.valor = 0;
        this.frecuencia = 0;
        this.desfase = 0;
        
        for (int i = 0; i < 3; i++){
            this.campos[i] = new JTextField();
            this.campos[i].setText(String.valueOf(0));
        }
        
        JLabel labelValor = new JLabel("Voltaje:");
        
        this.setLayout(new BorderLayout());
        JPanel panelTabla = new JPanel(new GridLayout(5,2,5,5));
        panelTabla.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelTabla.add(new JLabel("Fuente AC:"));
        panelTabla.add(new JLabel("  "));
        panelTabla.add(new JLabel("Tipo:"));
        String s1[] = { "Voltaje", "Corriente" };
        JComboBox c1 = new JComboBox(s1);
        c1.addActionListener(e -> {
            if (c1.getSelectedItem() == "Voltaje"){
                labelValor.setText("Voltaje:");
                this.tipo = 'V';
            } else {
                labelValor.setText("Corriente:");
                this.tipo = 'I';
            }
        });
        panelTabla.add(c1);
        
        
        
        panelTabla.add(labelValor);
        panelTabla.add(this.campos[0]);
        this.campos[0].setText("10");
        this.valor = 10;
        campos[0].setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {

                JTextField campo = (JTextField) input;

                try {

                    double valorNuevo = Double.parseDouble(campo.getText());

                    if (valorNuevo < 0) {
                        throw new NumberFormatException();
                    }

                    valor = valorNuevo;

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
        
        
        panelTabla.add(new JLabel("Frecuencia:"));
        panelTabla.add(this.campos[1]);
        this.frecuencia = 1;
        campos[1].setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {

                JTextField campo = (JTextField) input;

                try {

                    double valorNuevo = Double.parseDouble(campo.getText());

                    if (valorNuevo < 0) {
                        throw new NumberFormatException();
                    }

                    frecuencia = valorNuevo;

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
        
        
        
        this.campos[1].setText("1");
        panelTabla.add(new JLabel("Desfase:"));
        panelTabla.add(this.campos[2]);
        this.campos[2].setText("0");
        this.desfase = 0;
        campos[2].setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {

                JTextField campo = (JTextField) input;

                try {

                    double valorNuevo = Double.parseDouble(campo.getText());
                    desfase = valorNuevo;

                    return true;

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese un número válido"
                    );

                    campo.selectAll();

                    return false;
                }
            }
        });
        
        
        
        this.setMaximumSize(new Dimension(400,300));

        this.add(new JLabel("Fuente AC:"), BorderLayout.NORTH);
        this.add(panelTabla, BorderLayout.NORTH);
    }
    public String getLinea(){
        return this.tipo + " " + String.valueOf(this.valor) + " " + String.valueOf(this.frecuencia) + " " + String.valueOf(this.desfase);
    }
    public void setValor(double valor){
        this.valor = valor;
        this.campos[0].setText(String.valueOf(valor));
    }
    public void setFrecuencia(double valor){
        this.frecuencia = valor;
        this.campos[1].setText(String.valueOf(valor));
    }
    public void setDesfase(double valor){
        this.desfase = valor;
        this.campos[2].setText(String.valueOf(valor));
    }
    //TODO
    public void setTipo(char tipo){
        this.tipo = tipo;
    }
    
}
