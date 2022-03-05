package stage.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import stage.utils.CenterOnDefaultScreen;

public class HUDPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2412107051429282816L;
	private final int width = CenterOnDefaultScreen.center().width;
	private final int heigth = CenterOnDefaultScreen.center().height;

	public HUDPanel() {	
		this.setLayout(new GridLayout(4, 4));
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(width, heigth*10/100));

		this.add(new PlayerOneLabel(), 0, 0);
		this.add(new ScoreLabel(), 1, 1);
	}

}
