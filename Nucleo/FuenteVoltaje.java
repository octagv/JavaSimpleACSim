import java.lang.Math;
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
