package helpMenu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

import menu.utils.MenuLabel;

public class HelpPanel extends JPanel{

	private static final long serialVersionUID = 250843957477488551L;
	
	public HelpPanel() {
		super(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 0;
		container.gridy = 0;
		container.gridwidth = 3;
		container.ipadx = 100;
		container.ipady = 60;
		this.add(new MenuLabel("HELP", 7, Color.MAGENTA),  container);
		this.setBackground(Color.BLACK);
		
		String[][] commandString = {{"LEFT-ARROW", "MOVE LEFT"}, {"RIGHT-ARROW", "MOVE RIGHT"}, {"SPACE", "SHOOT"} };
		
		for (int i = 0; i < commandString.length; i++ ) {
			for (int j = 0; j < commandString[0].length; j++) {
				Color foregroundColor;
				if (j == 0) {
					foregroundColor = Color.GREEN;
				}else {
					foregroundColor = Color.WHITE;
				}
				container.gridwidth = 1;
				container.ipady = 10;
				container.gridx = 0 + j;
				container.gridy = 1 + i;
				this.add(new MenuLabel(commandString[i][j], 4, foregroundColor),  container);
			}
		}
		this.setVisible(false);
	}
}
