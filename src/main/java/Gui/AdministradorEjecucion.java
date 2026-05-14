/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Octav
 */
public class AdministradorEjecucion {
    private Almacenador almacen;
    
    public AdministradorEjecucion(){
        this.almacen = new Almacenador();
    }
    
    //Metodos para el Menubar de Archivo
    public void nuevoArchivo(){
        this.almacen.vaciar();
        System.out.println("Se limpio archivo");
    }
    public void guardarArchivo(){
        if(this.almacen.nombreArchivo.equals("")){
            this.guardarComoArchivo();
        } else {
            this.almacen.guardarArchivo();
        }
    }
    public void abrirArchivo(){
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos SCHMA (*.schma)","schma");

        selector.setFileFilter(filtro);
        int resultado = selector.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {

            File archivo = selector.getSelectedFile();

            this.almacen.nombreArchivo = archivo.getAbsolutePath();
            this.almacen.abrirArchivo();
        }
    }
    public void guardarComoArchivo(){
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro =
        new FileNameExtensionFilter(
                "Archivos SCHMA (*.schma)",
                "schma");

        selector.setFileFilter(filtro);
        selector.setAcceptAllFileFilterUsed(false);
        int resultado = selector.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {

            File archivo = selector.getSelectedFile();

            // Agregar extensión automáticamente
            if (!archivo.getName().endsWith(".schma")) {
                archivo = new File(archivo.getAbsolutePath() + ".schma");
            }
            this.almacen.nombreArchivo = archivo.getAbsolutePath();
            this.almacen.guardarArchivo();
        }
        
    }
    
    //Metodo de Ejecucion
    public void ejecutarSimulacion(){
        
    }
    
}
