/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

/**
 *
 * @author Octav
 */
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
		this.setJMenuBar(new BarraMenu());
	}
	private void construirBarraHerramientas(){
		this.getContentPane().add(new BarraHerramientas(), BorderLayout.PAGE_START);
	}
	private void construirCentro(){
		
		this.getContentPane().add(new JScrollPane(new Canvas()), BorderLayout.CENTER);
	}
}
