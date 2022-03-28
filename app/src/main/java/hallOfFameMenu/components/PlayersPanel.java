package hallOfFameMenu.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.FileNotFoundException;

import javax.swing.JPanel;

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
		playersPanel.add(new NicknameTitleLabel(),  container);
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 2;
		container.ipadx = 120;
		playersPanel.add(new ScoreTitleLabel(),  container);
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 3;
		container.ipadx = 120;
		playersPanel.add(new DateTitleLabel(),  container);
		
		Players p1 = new Players();
		p1.Read();
		Player p = new Player("GIGI");
		p.setScore(1500);
		p1.add(p);
		p1.Sort();
		p1.Save();
		
		for(int i = 0; i < p1.get(); i++) {
			String elem = Integer.toString(i+1);
			String score= Integer.toString(p1.get(i).getScore());
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 0;
			container.gridy = 1+i;
			container.ipadx = 120;
			playersPanel.add(new GenericLabel(elem),  container);
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 1;
			container.gridy = 1+i;
			container.ipadx = 120;
			playersPanel.add(new GenericLabel(p1.get(i).getNickname()),  container);
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 2;
			container.gridy = 1+i;
			container.ipadx = 120;
			playersPanel.add(new GenericLabel(score),  container);
			
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridx = 3;
			container.gridy = 1+i;
			container.ipadx = 120;
			playersPanel.add(new GenericLabel(p1.get(i).getDate()),  container);
		}
		
		playersPanel.setBackground(Color.black);
		this.setBackground(Color.black);
		this.add(playersPanel);
		
		
		
		
		
	}
}
