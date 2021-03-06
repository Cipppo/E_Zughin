package stage.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import stage.utils.AddAllLabels;
import stage.utils.CenterOnDefaultScreen;

/**
 * The HUD of the game.
 */
public class HUDPanel extends JPanel{
	
	private static final long serialVersionUID = -2412107051429282816L;
	private final int width = CenterOnDefaultScreen.center().width;
	private final int heigth = CenterOnDefaultScreen.center().height;
	private final int rows = 4;
	private final int columns = 7;
	private JPanel[][] HUDPanel = new JPanel[rows][columns];

	/**
	 * This constructor creates the grid for the HUD fields.
	 */
	public HUDPanel() {	
		this.setLayout(new GridLayout(rows, columns));

		for (int m = 0; m < rows; m++) {
			for (int n = 0; n < columns; n++) {
				HUDPanel[m][n] = new JPanel();
				HUDPanel[m][n].setBackground(Color.BLACK);
				this.add(HUDPanel[m][n]);
			}
		}
		this.setPreferredSize(new Dimension(width, heigth*12/100));

		AddAllLabels.add(HUDPanel);

	}

	/**
	 * @return
	 * 		The HUD panel.
	 */
	public JPanel[][] getHUDPanel() {
		return this.HUDPanel;
	}
}
