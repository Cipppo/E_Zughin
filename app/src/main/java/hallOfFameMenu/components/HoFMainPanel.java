package hallOfFameMenu.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import menu.utils.MenuLabel;

/**
 * Class to create the hall of fame panel
 *
 */
public class HoFMainPanel extends JPanel{
	
	private static final long serialVersionUID = 4822473142531885639L;

	/*
	 * Constructor without parameters
	 */
	public HoFMainPanel() {
		super(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 0;
		container.gridy = 0;
		
		this.add(new MenuLabel("HALL OF FAME", 7, Color.MAGENTA),  container); //add the title label
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 0;
		container.gridy = 1;
		
		this.add(new PlayersPanel(),  container);								//add PlayerPanel that has inside the 
		this.setBackground(Color.black);										//standings of the hall of fame
		this.setVisible(false);
	}
}
