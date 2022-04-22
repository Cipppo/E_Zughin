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
		this.add(new MenuLabel("HELP", 7, Color.MAGENTA),  container);
		this.setBackground(Color.BLACK);
		
		String[][] commandString = {{"LEFT-ARROW", "MOVE LEFT"}, {"RIGHT-ARROW", "MOVE RIGHT"}, {"SPACE", "SHOOT"} };
		for (int i = commandString.length; i < commandString.length; i++ ) {
			for (int j = commandString[0].length; j < commandString[0].length; i++) {
				container.gridx = 0 + j;
				container.gridy = 1 + i;
				this.add(new MenuLabel("SUCA", 4, Color.GREEN),  container);
			}
		}
	}
}
