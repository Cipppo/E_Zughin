package hallOfFame.gui;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

import hallOfFameMenu.components.MainPanel;
import stage.utils.CenterOnDefaultScreen;

public class Gui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3198091415309833274L;
	private final int width = CenterOnDefaultScreen.center().width;
	private final int heigth = CenterOnDefaultScreen.center().height;
	
	public Gui() throws FileNotFoundException {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setSize(width*70/100, heigth*70/100);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(new MainPanel(), BorderLayout.CENTER);
		
		
		
		this.setVisible(true);
	}
}
