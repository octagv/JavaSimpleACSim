/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nucleo;

/**
 *
 * @author Octav
 */
public class FuenteVoltaje extends Fuente{
	private NumeroComplejo voltaje;
	private double frecuencia;

	public FuenteVoltaje(double voltaje, double frecuencia) {
		this.voltaje = new NumeroComplejo(voltaje, 0);
		this.frecuencia = frecuencia;
	}
	public FuenteVoltaje(NumeroComplejo v, double frecuencia){
		this.voltaje = v;
		this.frecuencia = frecuencia;
	}
	public FuenteVoltaje(double voltaje, double frecuencia, double desfaceEnGrados){
		this.frecuencia = frecuencia;
		double ang = Math.toRadians(desfaceEnGrados);
		this.voltaje = new NumeroComplejo(voltaje*Math.cos(ang), voltaje*Math.sin(ang));
	}

	public double getFrecuencia(){
		return this.frecuencia;
	}
	public NumeroComplejo getVoltaje(){
		return this.voltaje;
	}

}
