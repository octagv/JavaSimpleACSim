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
    private AdministradorEjecucion admin;
    public BarraHerramientas (AdministradorEjecucion adm) {
        super("Herramientas");
        this.admin = adm;
        JButton botonResistencia = new JButton("R");
        botonResistencia.addActionListener(e -> {
            System.out.println("Cambio algo");
            this.admin.cambiarElemento(0);
        });
        JButton botonInductor = new JButton("L");
        botonInductor.addActionListener(e -> {
            System.out.println("Cambio algo");
            this.admin.cambiarElemento(2);
        });
        JButton botonCapacitor = new JButton("C");
        botonCapacitor.addActionListener(e -> {
            System.out.println("Cambio algo");
            this.admin.cambiarElemento(1);
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
}
