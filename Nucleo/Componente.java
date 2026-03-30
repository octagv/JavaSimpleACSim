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
