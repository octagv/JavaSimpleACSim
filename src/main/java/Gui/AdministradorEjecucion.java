/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Octav
 */
public class AdministradorEjecucion {
    private int contadorResistencias = 0;
    private int contadorCapacitores = 0;
    private int contadorInductores = 0;
    
    
    private Almacenador almacen;
    private PantallaPrincipal app;
    public AdministradorEjecucion(PantallaPrincipal pantalla){
        this.almacen = new Almacenador();
        this.app = pantalla;
    }
    
    //Metodos para el Menubar de Archivo
    public void nuevoArchivo(){
        this.limpiarCanvas();
        this.almacen.vaciar();
        System.out.println("Se limpio archivo");
        this.genCircuitoInicial();
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
            this.limpiarCanvas();
            this.almacen.abrirArchivo();
            
            this.dibujarCanvas();
            
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
    // FUNCIONES BARRA DE HERRAMIENTAS
    public void cambiarElemento(int id){
        Celda aux = this.app.canvas.obtenerCeldaActual();
        if( (aux != null) && aux.esComponente()){
            aux.setId(id);
            int indice = this.almacen.buscarGraficoPorPosicion(aux.posX, aux.posY);
            if(indice >= 0){
                this.almacen.graficos.set(indice, aux.getLinea());
                this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Necesita tener un componente seleccionado para la accion");
        }
    }
    
    //FUNCIONES PARA MANEJO DE CANVAS
    
    public void agregarComponente(int x, int y, int id, String nombre){
        String dato = String.valueOf(id) + " " + String.valueOf(x) + " " + String.valueOf(y) + " " + nombre;
        this.almacen.graficos.add(dato);
        this.app.menuLat.listaComponentes.agregarComponente();
        Celda aux = Celda.ComponentedesdeString(dato, nombre);
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
    }
    public void limpiarCanvas(){
        for(String str: this.almacen.graficos){
            String pos[] = str.split(" ");
            this.app.canvas.eliminarCelda(Integer.parseInt(pos[1]),Integer.parseInt(pos[2]));
        }
    }
    public void dibujarCanvas(){
        Celda aux;
        for (String dato : this.almacen.graficos){
            String[] datos = dato.split(" ");
            if (datos.length == 3){
                aux = Celda.desdeString(dato);  
            } else {
                aux = Celda.ComponentedesdeString(dato, datos[3]);
            }
            this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        }
    }
    public void genCircuitoInicial(){
        Celda aux;
        
        this.almacen.graficos.add("4 6 5");
        aux = Celda.desdeString("4 6 5");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        
        this.almacen.graficos.add("0 6 7 R1");
        aux = Celda.ComponentedesdeString("0 6 7", "R1");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        this.app.menuLat.listaComponentes.agregarComponente();
        
        this.almacen.graficos.add("7 5 5");
        aux = Celda.desdeString("7 5 5");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        
        this.almacen.graficos.add("8 5 7");
        aux = Celda.desdeString("8 5 7");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        
        this.almacen.graficos.add("9 7 5");
        aux = Celda.desdeString("9 7 5");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        
        this.almacen.graficos.add("10 7 7");
        aux = Celda.desdeString("10 7 7");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        
        this.almacen.graficos.add("5 5 6");
        aux = Celda.desdeString("5 5 6");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        
        this.almacen.graficos.add("5 7 6");
        aux = Celda.desdeString("5 7 6");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
    }
    
    //Metodo de Ejecucion
    public void ejecutarSimulacion(){
        
    }
    
}
