/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nucleo;

/**
 *
 * @author Octav
 */
public abstract class Componente {
	protected NumeroComplejo voltaje;
	protected NumeroComplejo corriente;
	protected NumeroComplejo impedancia;
	protected String nombre;

	public void reporte() {
		System.out.println("Nombre: " + this.nombre + " Impedancia: " + this.impedancia + " Voltaje: " + this.voltaje + " Corriente: " + this.corriente);
	}
	public abstract void calcularConVoltaje(FuenteVoltaje v);
	public abstract void calcularConCorriente(FuenteCorriente i);
	public abstract NumeroComplejo getImpedancia(double frecuencia);

	public void setNombre(String nombre){
		if(!nombre.equals("")){
			this.nombre = nombre;
		}
	}
}
