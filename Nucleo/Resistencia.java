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

	public void calcularConVoltaje(FuenteVoltaje v){
		this.voltaje = v.getVoltaje();
		this.corriente = NumeroComplejo.division(v.getVoltaje(), this.impedancia);
	}
	public void calcularConCorriente(FuenteCorriente i){
		this.corriente = i.getCorriente();
		this.voltaje = NumeroComplejo.multiplicacion(this.corriente, this.impedancia);
	}
	public NumeroComplejo getImpedancia(double frecuencia){
		return this.impedancia;
	}
}
