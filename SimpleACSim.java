import java.io.FileNotFoundException;
public class SimpleACSim {
	public static void main(String[] args){
		Circuito miCircuito;
		try {
			miCircuito = Circuito.generarDesdeTXT("archivo.txt");
			miCircuito.calcular();
			miCircuito.reporte();
		} catch(FileNotFoundException e){
			System.out.println("Error Fatal");
		}


	}
}
