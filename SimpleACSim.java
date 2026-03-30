import java.io.FileNotFoundException;
public class SimpleACSim {
	public static void main(String[] args){
		try {
			Circuito miCircuito = Circuito.generarDesdeTXT("archivo.txt");
		} catch(FileNotFoundException e){
			System.out.println("Error Fatal");
		}

	}
}
