/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nucleo;

/**
 *
 * @author Octav
 */
public class Capacitor extends Componente {
	private double capacitancia;

	public Capacitor(String nombre, double valor) {
		this.nombre = nombre;
		this.corriente = new NumeroComplejo(0,0);
		this.voltaje = new NumeroComplejo(0,0);
		this.impedancia = new NumeroComplejo(0,-1);
		this.capacitancia = 1;
		this.setCapacitancia(valor);
	}
	public void setCapacitancia(double valor){
		if(valor > 0) this.capacitancia = valor;
	}
        @Override
	public NumeroComplejo getImpedancia(double frecuencia) {
		return new NumeroComplejo(0, -(1)/(2*Math.PI*frecuencia*this.capacitancia));
	}
        @Override
	public void calcularConVoltaje(FuenteVoltaje v) {
		this.voltaje = v.getVoltaje();
		this.impedancia = this.getImpedancia(v.getFrecuencia());
		this.corriente = NumeroComplejo.division(v.getVoltaje(), this.impedancia);
	}
        @Override
	public void calcularConCorriente(FuenteCorriente i) {
		this.corriente = i.getCorriente();
		this.impedancia = this.getImpedancia(i.getFrecuencia());
		this.voltaje = NumeroComplejo.multiplicacion(this.corriente, this.impedancia);
	}
}

