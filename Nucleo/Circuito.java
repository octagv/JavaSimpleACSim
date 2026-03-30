import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Circuito {
	private Componente[] componentes = new Componente[10];	
	private Fuente fuenteCircuito;
	private Componente raiz;

	public void calcular(){
		if (this.fuenteCircuito instanceof FuenteCorriente) {
			this.raiz.calcularConCorriente((FuenteCorriente)this.fuenteCircuito);
		} else if(this.fuenteCircuito instanceof FuenteVoltaje) {
			this.raiz.calcularConVoltaje((FuenteVoltaje)this.fuenteCircuito);
		}
	}
	public void reporte(){
		System.out.println("**********REPORTE**********");
		this.raiz.reporte();
		for(Componente c : componentes){
			c.reporte();
		}
	}
	static public Circuito generarDesdeTXT(String nombre) throws FileNotFoundException {
		File miArchivo = new File(nombre);
		Scanner scan = new Scanner(miArchivo);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			System.out.println(linea);
			//TODO: PROCESADO DE TEXTO
		}
		scan.close();
		FileNotFoundException e = new FileNotFoundException();
		throw e;
	}
}
