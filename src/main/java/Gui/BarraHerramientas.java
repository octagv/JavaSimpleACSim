/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import javax.swing.JToolBar;
import javax.swing.JButton;

/**
 *
 * @author Octav
 */
public class BarraHerramientas extends JToolBar {
    public BarraHerramientas () {
        super("Herramientas");
        JButton botonResistencia = new JButton("R");
        JButton botonInductor = new JButton("L");
        JButton botonCapacitor = new JButton("C");
        JButton botonSerie = new JButton("S");
        JButton botonParalelo = new JButton("P");
        this.add(botonResistencia);
        this.add(botonInductor);
        this.add(botonCapacitor);
        this.add(botonSerie);
        this.add(botonParalelo);
    }
}
