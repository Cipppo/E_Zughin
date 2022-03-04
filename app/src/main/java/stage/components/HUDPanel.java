package stage.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JPanel;

import stage.utils.CenterOnDefaultScreen;

public class HUDPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2412107051429282816L;
	private final int width = CenterOnDefaultScreen.center().get("width");
	private final int heigth = CenterOnDefaultScreen.center().get("heigth");

	public HUDPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.red);
		this.setPreferredSize(new Dimension(width, heigth*10/100));
		
		this.add(new PlayerOneLabel(), BorderLayout.WEST);
	}

}
