/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nucleo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Locale;

/**
 *
 * @author Octav
 */
public class Circuito {
	private LinkedList<Componente> componentes = new LinkedList();	
	private Fuente fuenteCircuito;
	private Componente raiz;

	public void calcular(){
		if (this.fuenteCircuito instanceof FuenteCorriente) {
			this.raiz.calcularConCorriente((FuenteCorriente)this.fuenteCircuito);
		} else if(this.fuenteCircuito instanceof FuenteVoltaje) {
			this.raiz.calcularConVoltaje((FuenteVoltaje)this.fuenteCircuito);
		}
	}
	public String reporte(){
            String miReporte = "";
            String nombre = this.raiz.getNombre();
            System.out.println("**********REPORTE**********");
            miReporte += "**********REPORTE**********\n";
            this.raiz.setNombre("Circuito Final");
            miReporte += this.raiz.reporte();
            miReporte += "\n";
            if( nombre != null) this.raiz.setNombre(nombre);
            for(Componente c : componentes){
                    miReporte += c.reporte();
                    miReporte += "\n";
            }
            return miReporte;
	}
	static public Circuito generarDesdeTXT(String nombre) throws FileNotFoundException {
		File miArchivo = new File(nombre);
		Scanner scan = new Scanner(miArchivo);
                scan.useLocale(Locale.US);
		Circuito miCircuito = new Circuito();
		String opt;
		opt = scan.next();
		if(opt.equals("V")){
			miCircuito.fuenteCircuito = new FuenteVoltaje(scan.nextDouble(), scan.nextDouble(), scan.nextDouble());
		} else if (opt.equals("I")) {
			miCircuito.fuenteCircuito = new FuenteCorriente(scan.nextDouble(), scan.nextDouble(), scan.nextDouble());
		}
		scan.nextLine();


		LinkedList<Componente> pila = new LinkedList();
		while (scan.hasNextLine()) {
			opt = scan.next();
			switch(opt) {
				case "R" -> {
                                    pila.add(new Resistencia(scan.next(), scan.nextDouble()));
                                    miCircuito.componentes.add(pila.getLast());
                        }
				case "L" -> {
                                    pila.add(new Inductor(scan.next(), scan.nextDouble()));
                                    miCircuito.componentes.add(pila.getLast());
                        }
				case "C" -> {
                                    pila.add(new Capacitor(scan.next(), scan.nextDouble()));
                                    miCircuito.componentes.add(pila.getLast());
                        }
                                case "K" -> {
                                    pila.add(new Cortocircuito(scan.next()));
                                    miCircuito.componentes.add(pila.getLast());
                        }
				case "P" -> pila.add(new Paralelo(pila.removeLast(), pila.removeLast()));
				case "S" -> pila.add(new Serie(pila.removeLast(), pila.removeLast()));
			}
			scan.nextLine();
		}
		scan.close();
		miCircuito.raiz = pila.removeLast();
		//miCircuito.raiz.setNombre("Circuito Total");
		return miCircuito;
	}
}
