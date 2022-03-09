package menu.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import menu.components.MainPanel;
import stage.utils.CenterOnDefaultScreen;

public class Gui extends JFrame{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5959162590670099057L;
	private final int width = CenterOnDefaultScreen.center().width;
	private final int heigth = CenterOnDefaultScreen.center().height;

	public Gui() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setSize(width*70/100, heigth*70/100);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(new MainPanel(), BorderLayout.CENTER);
		
		
		this.setVisible(true);
	}
}
