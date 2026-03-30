public class FuenteCorriente extends Fuente {
	private double frecuencia;
	private NumeroComplejo corriente;

	public FuenteCorriente(double corriente, double frecuencia) {
		this.frecuencia = frecuencia;
		this.corriente = new NumeroComplejo(corriente, 0);
	}
	public FuenteCorriente(NumeroComplejo corriente, double frecuencia) {
		this.frecuencia = frecuencia;
		this.corriente = corriente;
	}

	public double getFrecuencia(){
		return this.frecuencia;
	}
	public NumeroComplejo getCorriente() {
		return this.corriente;
	}
}
