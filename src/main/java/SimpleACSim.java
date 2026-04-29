/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Octav
 */
import Nucleo.Circuito;
//import Gui.PantallaPrincipal;
//import java.io.File;
import java.io.FileNotFoundException;
public class SimpleACSim {
	public static void main(String[] args){
            //PantallaPrincipal miPantalla = new PantallaPrincipal();
		Circuito miCircuito;
		try {
			miCircuito = Circuito.generarDesdeTXT("./src/main/java/test.txt");
			miCircuito.calcular();
			miCircuito.reporte();
		} catch(FileNotFoundException e){
			System.out.println("Error Fatal");
		}
            /*File carpeta = new File("./src/main/java/test.txt");

            String[] archivos = carpeta.list();

            if (archivos != null) {
                for (String nombre : archivos) {
                    System.out.println(nombre);
                }
            } else {
                System.out.println("No se pudo acceder al directorio.");
            }
            */
	}
}

