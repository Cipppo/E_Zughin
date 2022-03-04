package stage.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import stage.utils.*;
import stage.components.*;

public class Gui extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4255916723363898550L;
	
	private final int width = CenterOnDefaultScreen.center().width;
	private final int heigth = CenterOnDefaultScreen.center().height;

	public Gui() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setSize(width*70/100, heigth*70/100);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.add(new HUDPanel(), BorderLayout.SOUTH);
		this.add(new MainPanel(), BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
}
