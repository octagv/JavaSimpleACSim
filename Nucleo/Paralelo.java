public class Paralelo extends Componente {
	private Componente a;
	private Componente b;

	public Paralelo(Componente a, Componente b) {
		this.a = a;
		this.b = b;
	}
	public NumeroComplejo getImpedancia(double frecuencia){
		NumeroComplejo impedanciaA = this.a.getImpedancia(frecuencia);
		NumeroComplejo impedanciaB = this.b.getImpedancia(frecuencia);
		return NumeroComplejo.division(NumeroComplejo.multiplicacion(impedanciaA, impedanciaB), NumeroComplejo.suma(impedanciaA, impedanciaB));
		
	}
	public void calcularConVoltaje(FuenteVoltaje v){
		this.voltaje = v.getVoltaje();

		this.impedancia = this.getImpedancia(v.getFrecuencia());
		this.corriente = NumeroComplejo.division(this.voltaje, this.impedancia);

		this.a.calcularConVoltaje(v);
		this.b.calcularConVoltaje(v);
	}
	public void calcularConCorriente(FuenteCorriente i) {
		this.corriente = i.getCorriente();
		NumeroComplejo impedanciaA = this.a.getImpedancia(i.getFrecuencia());
		NumeroComplejo impedanciaB = this.b.getImpedancia(i.getFrecuencia());
		this.impedancia = NumeroComplejo.division(NumeroComplejo.multiplicacion(impedanciaA, impedanciaB), NumeroComplejo.suma(impedanciaA, impedanciaB));
		
		this.voltaje = NumeroComplejo.multiplicacion(this.corriente,this.impedancia);
		
		NumeroComplejo corrienteA = NumeroComplejo.multiplicacion(this.corriente, NumeroComplejo.division(impedanciaB, this.impedancia));
		NumeroComplejo corrienteB = NumeroComplejo.multiplicacion(this.corriente, NumeroComplejo.division(impedanciaA, this.impedancia));
		FuenteCorriente ia = new FuenteCorriente(corrienteA, i.getFrecuencia());
		FuenteCorriente ib = new FuenteCorriente(corrienteB, i.getFrecuencia());

		this.a.calcularConCorriente(ia);
		this.b.calcularConCorriente(ib);
	}
}
