import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
public class PantallaPrincipal extends JFrame {
	private JMenuBar menubar;
	private JMenu menuArchivo;
	public PantallaPrincipal() {
		super("Programa");
		this.setSize(1800,1000);
		this.construirMenu();
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.construirBarraHerramientas();
		this.construirCentro();
		this.getContentPane().add(new MenuLateral(), BorderLayout.LINE_END);
		this.setVisible(true);
	}
	private void construirMenu(){
		this.menubar = new JMenuBar();
		this.menuArchivo = new JMenu("Archivo");
		JMenuItem nuevoArchivo, abrirArchivo, guardarArchivo;
		this.menuArchivo.add(new JMenuItem("Nuevo"));
		this.menuArchivo.add(new JMenuItem("Abrir"));
		this.menuArchivo.add(new JMenuItem("Guardar"));
		this.menuArchivo.add(new JMenuItem("Guardar como.."));
		this.menubar.add(this.menuArchivo);
		this.setJMenuBar(this.menubar);
	}
	private void construirBarraHerramientas(){
		JToolBar herramientas = new JToolBar("Herramientas");
		JButton botonResistencia = new JButton("R");
		JButton botonInductor = new JButton("L");
		JButton botonCapacitor = new JButton("C");
		JButton botonSerie = new JButton("S");
		JButton botonParalelo = new JButton("P");
		herramientas.add(botonResistencia);
		herramientas.add(botonInductor);
		herramientas.add(botonCapacitor);
		herramientas.add(botonSerie);
		herramientas.add(botonParalelo);
		this.getContentPane().add(herramientas, BorderLayout.PAGE_START);
	}
	private void construirCentro(){
		int numeroCeldas = 50;
		int tamCelda = 60;
		JTable tabla = new JTable(50,50);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla.setRowHeight(tamCelda);
		for(int i=0; i<numeroCeldas;i++) {
			tabla.getColumnModel().getColumn(i).setPreferredWidth(tamCelda);
		}

		this.getContentPane().add(new JScrollPane(tabla), BorderLayout.CENTER);
	}
}
