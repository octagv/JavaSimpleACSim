/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
        
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        itemAbrir.addActionListener(e -> {
            admin.abrirArchivo();
        });
        
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        itemGuardar.addActionListener(e -> {
            admin.guardarArchivo();
        });
        
        JMenuItem itemGuardarComo = new JMenuItem("Guardar como..");
        itemGuardarComo.addActionListener(e -> {
            admin.guardarComoArchivo();
        });
        
        this.menuArchivo.add(itemNuevo);
        this.menuArchivo.add(itemAbrir);
        this.menuArchivo.add(itemGuardar);
        this.menuArchivo.add(itemGuardarComo);
        
        this.menuHerramientas.add(new JMenuItem("Resistencia"));
        this.menuHerramientas.add(new JMenuItem("Capacitor"));
        this.menuHerramientas.add(new JMenuItem("Inductor"));
        this.menuHerramientas.add(new JMenuItem("Serie"));
        this.menuHerramientas.add(new JMenuItem("Paralelo"));
        
        this.add(this.menuArchivo);
        this.add(this.menuHerramientas);
    }
}
