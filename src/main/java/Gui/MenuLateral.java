/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

/**
 *
 * @author Octav
 */
import javax.swing.BoxLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class MenuLateral extends JPanel {
	public MenuLateral(){
		super();
		LayoutManager layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		this.setLayout(layout);

		this.add(new ConfiguradorFuente());
		this.add(new ListaComponentes());

	}
}
