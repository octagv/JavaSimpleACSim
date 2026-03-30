import java.lang.Math;

public class NumeroComplejo {
	public double real;
	public double imag;

	public NumeroComplejo(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public double getModulo() {
		return Math.sqrt(this.real*this.real + this.imag*this.imag);
	}
	
	public double getAngulo() {
		return Math.atan2(this.imag, this.real);
	}

	public static NumeroComplejo suma(NumeroComplejo a, NumeroComplejo b) {
		double real = a.real + b.real;
		double imag = a.imag + b.imag;
		return new NumeroComplejo(real, imag);
	}
	public static NumeroComplejo multiplicacion(NumeroComplejo a, NumeroComplejo b) {
		return new NumeroComplejo(a.real*b.real - a.imag*b.imag, a.real*b.imag + a.imag*b.real);
	}
	public static NumeroComplejo division(NumeroComplejo a, NumeroComplejo b) {
		double denominador = b.real*b.real + b.imag*b.imag;
		double real = (a.real*b.real+a.imag*b.imag)/denominador;
		double imag = (a.imag*b.real - a.real*b.imag)/denominador;
		return new NumeroComplejo(real, imag);
	}
	public static NumeroComplejo reciproco(NumeroComplejo a){
		return NumeroComplejo.division(new NumeroComplejo(1,0), a);
	}

	public String toString(){
		return String.valueOf(this.getModulo()) + "¬" + String.valueOf(Math.toDegrees(this.getAngulo())) + "°";
	}
}
