/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
/**
 *
 * @author Octav
 */
public class BarraMenu extends JMenuBar {
    private JMenu menuArchivo;
    public BarraMenu() {
        super();
        this.menuArchivo = new JMenu("Archivo");
        //JMenuItem nuevoArchivo, abrirArchivo, guardarArchivo;
        this.menuArchivo.add(new JMenuItem("Nuevo"));
        this.menuArchivo.add(new JMenuItem("Abrir"));
        this.menuArchivo.add(new JMenuItem("Guardar"));
        this.menuArchivo.add(new JMenuItem("Guardar como.."));
        this.add(this.menuArchivo);
    }
}
