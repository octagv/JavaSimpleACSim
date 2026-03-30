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

	public double getFrecuencia(){
		return this.frecuencia;
	}
	public NumeroComplejo getVoltaje(){
		return this.voltaje;
	}

}
