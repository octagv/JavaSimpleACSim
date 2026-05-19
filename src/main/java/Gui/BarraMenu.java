/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Octav
 */
public class BarraMenu extends JMenuBar {
    private JMenu menuArchivo;
    private JMenu menuHerramientas;
    public BarraMenu(AdministradorEjecucion admin) {
        super();
        
        
        this.menuArchivo = new JMenu("Archivo");
        this.menuHerramientas = new JMenu("Herramientas");
        
        
        //JMenuItem nuevoArchivo, abrirArchivo, guardarArchivo;
        
        
        JMenuItem itemNuevo = new JMenuItem("Nuevo");
        itemNuevo.addActionListener(e -> {
            admin.nuevoArchivo();
        });
        itemNuevo.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK)
        );
        
        
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        itemAbrir.addActionListener(e -> {
            admin.abrirArchivo();
        });
        itemAbrir.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK)
        );
        
        
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        itemGuardar.addActionListener(e -> {
            admin.guardarArchivo();
        });
        itemGuardar.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK)
        );
        
        
        JMenuItem itemGuardarComo = new JMenuItem("Guardar como..");
        itemGuardarComo.addActionListener(e -> {
            admin.guardarComoArchivo();
        });
        itemGuardarComo.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK)
        );
        
        
        this.menuArchivo.add(itemNuevo);
        this.menuArchivo.add(itemAbrir);
        this.menuArchivo.add(itemGuardar);
        this.menuArchivo.add(itemGuardarComo);
        
        JMenuItem itemResistencia = new JMenuItem("Resistencia");
        itemResistencia.addActionListener(e -> {
            admin.cambiarElemento(0);
        });
        itemResistencia.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0));
        this.menuHerramientas.add(itemResistencia);
        
        JMenuItem itemInductor = new JMenuItem("Inductor");
        itemInductor.addActionListener(e -> {
            admin.cambiarElemento(2);
        });
        itemInductor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0));        
        this.menuHerramientas.add(itemInductor);
        
        JMenuItem itemCapacitor = new JMenuItem("Capacitor");
        itemCapacitor.addActionListener(e -> {
            admin.cambiarElemento(1);
        });
        itemCapacitor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0));
        this.menuHerramientas.add(itemCapacitor);
        
        JMenuItem itemSerie = new JMenuItem("agregar Serie");
        itemSerie.addActionListener(e -> {
            admin.agregarSerie();
        });
        itemSerie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0));
        this.menuHerramientas.add(itemSerie);
        
        JMenuItem itemParalelo = new JMenuItem("Agregar Paralelo");
        itemParalelo.addActionListener(e -> {
            admin.agregarParalelo();
        });
        itemParalelo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0));
        this.menuHerramientas.add(itemParalelo);
        
        this.add(this.menuArchivo);
        this.add(this.menuHerramientas);
    }
}
