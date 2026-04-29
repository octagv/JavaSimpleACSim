/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nucleo;

/**
 *
 * @author Octav
 */
public class Serie extends Componente {
	private Componente a;
	private Componente b;
	
	public Serie(Componente a, Componente b) {
		this.a = a;
		this.b = b;
	}
        @Override
	public NumeroComplejo getImpedancia(double frecuencia){	
		NumeroComplejo impedanciaA = this.a.getImpedancia(frecuencia);
		NumeroComplejo impedanciaB = this.b.getImpedancia(frecuencia);
		return NumeroComplejo.suma(impedanciaA, impedanciaB);
	}
        @Override
	public void calcularConVoltaje(FuenteVoltaje v) {
		this.voltaje = v.getVoltaje();
		NumeroComplejo impedanciaA = this.a.getImpedancia(v.getFrecuencia());
		NumeroComplejo impedanciaB = this.b.getImpedancia(v.getFrecuencia());
		
		this.impedancia = NumeroComplejo.suma(impedanciaA, impedanciaB);
		this.corriente = NumeroComplejo.division(this.voltaje, this.impedancia);
		NumeroComplejo vA = NumeroComplejo.multiplicacion(v.getVoltaje(), NumeroComplejo.division(impedanciaA, this.impedancia));	
		NumeroComplejo vB = NumeroComplejo.multiplicacion(v.getVoltaje(), NumeroComplejo.division(impedanciaB, this.impedancia));	
		this.a.calcularConVoltaje(new FuenteVoltaje(vA, v.getFrecuencia()));
		this.b.calcularConVoltaje(new FuenteVoltaje(vB, v.getFrecuencia()));
	}
        @Override
	public void calcularConCorriente(FuenteCorriente i) {
		this.corriente = i.getCorriente();
		this.impedancia = this.getImpedancia(i.getFrecuencia());
		this.voltaje = NumeroComplejo.multiplicacion(this.corriente, this.impedancia);

		this.a.calcularConCorriente(i);
		this.b.calcularConCorriente(i);	

	}
	
}
