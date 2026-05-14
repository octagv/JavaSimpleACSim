/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

/**
 *
 * @author Octav
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

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
        panelTabla.add(new JLabel("Frecuencia:"));
        panelTabla.add(this.campos[1]);
        panelTabla.add(new JLabel("Desfase:"));
        panelTabla.add(this.campos[2]);
        this.setMaximumSize(new Dimension(400,300));

        this.add(new JLabel("Fuente AC:"), BorderLayout.NORTH);
        this.add(panelTabla, BorderLayout.NORTH);
    }
    
    public char getTipo(){
        return this.tipo;
    }
    public double getValor(){
        return this.valor;
    }
    public double getFrecuencia(){
        return this.frecuencia;
    }
    public double getDesfase(){
        return this.desfase;
    }
    
}
