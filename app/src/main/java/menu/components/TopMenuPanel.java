package menu.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import menu.utils.MenuLabel;

/**
 * Class to create the top menu panel
 *
 */
public class TopMenuPanel extends JPanel{

	private static final long serialVersionUID = 4006611678235036671L;
	private MenuLabel title= new MenuLabel("PANG", 10, Color.MAGENTA);  					//title label
	private MenuLabel subtitle = new MenuLabel("ARCADE RETRO-GAME", 7, Color.MAGENTA);		//subtitle label
	
	/**
	 * Constructor without parameters
	 */
	public TopMenuPanel() {
		super(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		super.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 0;
		container.gridwidth = 3;
		super.add(title, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 1;
		container.gridwidth = 10;
		super.add(subtitle, container);
		
		this.setBackground(Color.BLACK);
	}
}
