/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import javax.swing.JToolBar;
import javax.swing.JButton;

import java.awt.Dimension;
/**
 *
 * @author Octav
 */
public class BarraHerramientas extends JToolBar {
    private int componente = 0;
    public BarraHerramientas () {
        super("Herramientas");
        JButton botonResistencia = new JButton("R");
        botonResistencia.addActionListener(e -> {
            this.componente = 0;
        });
        JButton botonInductor = new JButton("L");
        botonInductor.addActionListener(e -> {
            this.componente = 1;
        });
        JButton botonCapacitor = new JButton("C");
        botonCapacitor.addActionListener(e -> {
            this.componente = 2;
        });
        JButton botonSerie = new JButton("S");
        JButton botonParalelo = new JButton("P");
        JButton botonRUN = new JButton("RUN");
        this.add(botonResistencia);
        this.add(botonInductor);
        this.add(botonCapacitor);
        this.addSeparator(new Dimension(100,10));
        this.add(botonSerie);
        this.add(botonParalelo);
        this.addSeparator(new Dimension(100,10));
        this.add(botonRUN);
    }
    public int getComponente(){
        return this.componente;
    }
}
