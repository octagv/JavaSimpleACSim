/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nucleo;

/**
 *
 * @author Octav
 */
public class Resistencia extends Componente {
	private double resistencia;
	public Resistencia(String nombre, double valor) {
		this.nombre = nombre;
		this.voltaje = new NumeroComplejo(0,0);
		this.corriente = new NumeroComplejo(0,0);
		this.resistencia = 1;
		this.setResistencia(valor);
	}
	public void setResistencia(double resistencia) {
		if (resistencia > 0) this.resistencia = resistencia;
		this.impedancia = new NumeroComplejo(this.resistencia,0);
	}
        @Override
	public void calcularConVoltaje(FuenteVoltaje v){
		this.voltaje = v.getVoltaje();
		this.corriente = NumeroComplejo.division(v.getVoltaje(), this.impedancia);
	}
        @Override
	public void calcularConCorriente(FuenteCorriente i){
		this.corriente = i.getCorriente();
		this.voltaje = NumeroComplejo.multiplicacion(this.corriente, this.impedancia);
	}
        @Override
	public NumeroComplejo getImpedancia(double frecuencia){
		return this.impedancia;
	}
}
