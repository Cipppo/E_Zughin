package hallOfFameMenu.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.FileNotFoundException;

import javax.swing.JPanel;

import menu.utils.MenuLabel;
import player.*;

public class PlayersPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2384551614346168327L;
	
	public PlayersPanel() throws FileNotFoundException {
		JPanel playersPanel = new JPanel(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		playersPanel.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 1;
		container.ipadx = 120;
		playersPanel.add(new MenuLabel("NICKNAME", 3, Color.GREEN),  container);
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 2;
		container.ipadx = 120;
		playersPanel.add(new MenuLabel("SCORE", 3, Color.GREEN),  container);
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 3;
		container.ipadx = 120;
		playersPanel.add(new MenuLabel("DATE", 3, Color.GREEN),  container);
		
		Players p1 = new Players();
		p1.Read();
		
		/*Player p = new Player("TOTTI");
		p.setScore(20000);
		p1.add(p);*/
		
		p1.Sort();
		p1.Save();
		
		for(int i = 0; i < p1.get(); i++) {
			String elem = Integer.toString(i+1);
			String score= Integer.toString(p1.get(i).getScore());
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 0;
			container.gridy = 1+i;
			container.ipadx =40;
			playersPanel.add(new MenuLabel(elem, 3),  container);
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 1;
			container.gridy = 1+i;
			container.ipadx = 40;
			playersPanel.add(new MenuLabel(p1.get(i).getNickname(), 3),  container);
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 2;
			container.gridy = 1+i;
			container.ipadx = 120;
			playersPanel.add(new MenuLabel(score, 3),  container);
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 3;
			container.gridy = 1+i;
			container.ipadx = 120;
			playersPanel.add(new MenuLabel(p1.get(i).getDate(), 3),  container);
		}
		
		playersPanel.setBackground(Color.black);
		this.setBackground(Color.black);
		this.add(playersPanel);
		
		
		
		
		
	}
}
