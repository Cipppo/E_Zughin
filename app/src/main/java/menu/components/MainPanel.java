package menu.components;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

public class MainPanel extends JPanel{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3036609648280707540L;
	private final int rows = 5;
	private final int columns = 3;

	public MainPanel() {
		JPanel[][] MainPanel = new JPanel[rows][columns];
		this.setLayout(new GridLayout(rows, columns));
		for(int m = 0; m < rows; m++) {
			for(int n = 0; n < columns; n++) {
				MainPanel[m][n] = new JPanel();
				MainPanel[m][n].setBackground(Color.BLACK);
				this.add(MainPanel[m][n]);
			}
		}
		this.setBackground(Color.black);
		
		MainPanel[1][1].add(new TitlePanel());
		MainPanel[2][1].add(new SubtitlePanel());
		MainPanel[3][1].add(new StartPanel());
		MainPanel[3][0].add(new SelectionPanel());
		MainPanel[3][2].add(new SelectionPanel());
		MainPanel[4][1].add(new HallOfFamePanel());
	}

}
