/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import Nucleo.Circuito;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Octav
 */
public class AdministradorEjecucion {
    private int contadorComponentes = 1;
    private int contadorCables = 2;
    
    
    private Almacenador almacen;
    private PantallaPrincipal app;
    public AdministradorEjecucion(PantallaPrincipal pantalla){
        this.almacen = new Almacenador();
        this.app = pantalla;
    }
    
    //Metodos para el Menubar de Archivo
    public void nuevoArchivo(){
        this.limpiarCanvas();
        this.app.menuLat.listaComponentes.vaciar();
        this.almacen.vaciar();
        System.out.println("Se limpio archivo");
        this.genCircuitoInicial();
    }
    public void guardarArchivo(){
        this.almacen.circuito.set(0, this.app.menuLat.configuradorFuente.getLinea());
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
            this.cargarFuente();
            this.cargarElementos();
            
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
            if(aux.esHorizontal()) aux.setId(id + 16 ); else aux.setId(id);
            int indice = this.almacen.buscarGraficoPorPosicion(aux.posX, aux.posY);
            if(indice >= 0){
                this.almacen.graficos.set(indice, aux.getLinea());
                this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
                this.app.menuLat.listaComponentes.obtenerPorNombre(aux.nombre).setId(id);
            }
            indice = this.almacen.buscarCircuitoPorNombre(aux.nombre);
            System.out.println(indice);
            if(indice >= 0){
                String linea = this.almacen.circuito.get(indice);
                switch(id){
                    case 0:
                        linea = "R" + linea.substring(1);
                        break;
                    case 1:
                        linea = "C" + linea.substring(1);
                        break;
                    case 2:
                        linea = "L" + linea.substring(1);
                        break;
                }
                this.almacen.circuito.set(indice, linea);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Necesita tener un componente seleccionado para la accion");
        }
    }
    
    public void agregarSerie(){
        Celda aux = this.app.canvas.obtenerCeldaActual();
        if(aux != null){
            if(aux.esCable()){
                int indice = this.almacen.buscarGraficoPorNombre(aux.nombreId);
                this.contadorComponentes += 1;
                int id  = 0;
                if(aux.esHorizontal())id = 16;
                this.agregarComponente(aux.posX, aux.posY, id, "e" + String.valueOf(this.contadorComponentes));
                indice = this.almacen.buscarCircuitoPorNombre(aux.nombreId);
                this.almacen.circuito.set(indice, "R " + "e" + String.valueOf(this.contadorComponentes) + " " + "1" );
            }
        } else {
            JOptionPane.showMessageDialog(null, "Necesita tener un componente seleccionado para la accion");
        }
    }
    
    //Metodo de Ejecucion
    public void ejecutarSimulacion(){
        for (String str : this.almacen.circuito){
                System.out.println(str);
            }
        try {
            File myFile = new File("temporal.txt");
            FileWriter fw = new FileWriter(myFile);
            this.almacen.circuito.set(0,this.app.menuLat.configuradorFuente.getLinea());
            for (String str : this.almacen.circuito){
                fw.write(str);
                fw.write("\n");
            }
            fw.close();
            Circuito circuito = Circuito.generarDesdeTXT("temporal.txt");
            circuito.calcular();
            //Cambiar
            String resultado = circuito.reporte();
            //myFile.delete();
            JOptionPane.showMessageDialog(null, resultado);
        } catch (IOException e){
            System.out.println("Error Garrafal");
        }
        
        
    }
    
    //FUNCIONES PARA MANEJO DE CANVAS
    
    public void agregarComponente(int x, int y, int id, String nombre){
        String dato = String.valueOf(id) + " " + String.valueOf(x) + " " + String.valueOf(y) + " " + nombre;
        this.almacen.graficos.add(dato);
        this.app.menuLat.listaComponentes.agregarComponente(nombre, id, 1).setAdmin(this);
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
        this.almacen.circuito.addFirst(this.app.menuLat.configuradorFuente.getLinea());
        
        this.almacen.graficos.add("4 6 5");
        aux = Celda.desdeString("4 6 5");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        
        this.almacen.graficos.add("0 6 7 e1");
        aux = Celda.ComponentedesdeString("0 6 7", "e1");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        this.app.menuLat.listaComponentes.agregarComponente("e1", 0, 1).setAdmin(this);
        this.almacen.circuito.add("K #1");
        this.almacen.circuito.add("R e1 1");
        this.almacen.circuito.add("S");
        this.almacen.circuito.add("K #2");
        this.almacen.circuito.add("S");
        
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
        
        this.almacen.graficos.add("5 5 6 #1");
        aux = Celda.desdeString("5 5 6 #1");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        
        this.almacen.graficos.add("5 7 6 #2");
        aux = Celda.desdeString("5 7 6 #2");
        this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
    }  

    
    public void cargarFuente(){
        String[] datos = this.almacen.circuito.get(0).split(" ");
        this.app.menuLat.configuradorFuente.setValor(Double.parseDouble(datos[1]));
        this.app.menuLat.configuradorFuente.setFrecuencia(Double.parseDouble(datos[2]));
        this.app.menuLat.configuradorFuente.setDesfase(Double.parseDouble(datos[3]));
    }
    public void cargarElementos(){
        this.app.menuLat.listaComponentes.vaciar();
        for(String dato: this.almacen.circuito){
            String[] datos = dato.split(" ");
            if(datos[0].startsWith("R")){
                this.app.menuLat.listaComponentes.agregarComponente(datos[1], 0, Double.parseDouble(datos[2]));
            } else if(datos[0].startsWith("L")){
                this.app.menuLat.listaComponentes.agregarComponente(datos[1], 1, Double.parseDouble(datos[2]));
            } else if(datos[0].startsWith("C")){
                this.app.menuLat.listaComponentes.agregarComponente(datos[1], 2, Double.parseDouble(datos[2]));
            }
        }
    }
    
    public void actualizarComponente(String nombre, String nuevoNombre, double valor, int tipo){
        int indice = this.almacen.buscarCircuitoPorNombre(nombre);
        String dato = nuevoNombre + " " + String.valueOf(valor);
        dato = switch (tipo) {
            case 0 -> "R " + dato;
            case 1 -> "C " + dato;
            default -> "L " + dato;
        };
        if(indice >= 0) {
            this.almacen.circuito.set(indice, dato);
        }
        
        this.app.menuLat.listaComponentes.renombrarItem(nombre, nuevoNombre);
        
        indice = this.almacen.buscarGraficoPorNombre(nombre);
        if(indice >= 0){
            dato = this.almacen.graficos.get(indice);
            if(Integer.parseInt(dato.split(" ")[0]) > 15){
                dato = String.valueOf(tipo + 16) + dato.substring(2);
            } else {
                dato = String.valueOf(tipo) + dato.substring(1);
            }
            
            dato = dato.replaceFirst(nombre, nuevoNombre);
            this.almacen.graficos.set(indice, dato);
            System.out.println(dato);
            Celda aux = Celda.desdeString(dato);
            this.app.canvas.agregarCelda(aux, aux.posX, aux.posY);
        }
        for(String str: this.almacen.graficos){
            System.out.println(str);
        }


    }
    
}
