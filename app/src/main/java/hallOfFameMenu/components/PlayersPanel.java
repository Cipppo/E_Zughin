package hallOfFameMenu.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import menu.utils.MenuLabel;
import player.*;

/**
 * Class to create the standings subpanel of the hall of fame
 */
public class PlayersPanel extends JPanel{

	private static final long serialVersionUID = -2384551614346168327L;
	private GridBagConstraints container; //used for the layout
	
	/*
	 * Constructor without parameters
	 */
	public PlayersPanel() {
		super(new GridBagLayout());
		container = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 1;
		container.ipadx = 120;
		this.add(new MenuLabel("NICKNAME", 3, Color.GREEN),  container);
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 2;
		this.add(new MenuLabel("SCORE", 3, Color.GREEN),  container);
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 3;
		this.add(new MenuLabel("DATE", 3, Color.GREEN),  container);
		
		Players p1 = new Players();
		p1.Read();
		
		/*Player player = new Player("MICHI");
		player.increaseScore(3000);
		p1.add(player);
		p1.Save();*/
		
		
		createStandings(p1);
		this.setBackground(Color.black);
	}
	
	/**
	 * It adds the standings panel
	 * @param p container of object player
	 */
	public void createStandings(Players p) {
		for(int i = 0; i < p.get(); i++) {
			String elem = Integer.toString(i+1);
			String score= Integer.toString(p.get(i).getScore().getScore());
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 0;
			container.gridy = 1+i;
			container.ipadx =40;
			this.add(new MenuLabel(elem, 3),  container);
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 1;
			container.gridy = 1+i;
			container.ipadx = 40;
			this.add(new MenuLabel(p.get(i).getNickname(), 3),  container);
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 2;
			container.gridy = 1+i;
			container.ipadx = 120;
			this.add(new MenuLabel(score, 3),  container);
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 3;
			container.gridy = 1+i;
			container.ipadx = 120;
			this.add(new MenuLabel(p.get(i).getDate(), 3),  container);
		}
<<<<<<< HEAD
		
		this.setBackground(Color.black);
=======
>>>>>>> 0dcd86f (last javadoc)
	}
}
