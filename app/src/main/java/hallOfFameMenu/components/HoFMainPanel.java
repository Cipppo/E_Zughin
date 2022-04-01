package hallOfFameMenu.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.FileNotFoundException;

import javax.swing.JPanel;

public class HoFMainPanel extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4822473142531885639L;

	public HoFMainPanel() throws FileNotFoundException {
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		mainPanel.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 0;
		container.gridy = 0;
		mainPanel.add(new TitleLabel("HALL OF FAME"),  container);
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 0;
		container.gridy = 1;
		mainPanel.add(new PlayersPanel(),  container);
		
		
		
		
		mainPanel.setBackground(Color.black);
		this.setBackground(Color.black);
		this.add(mainPanel);
		this.setVisible(false);
	}
}
