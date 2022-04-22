package endGame;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import menu.utils.MenuLabel;
import player.Player;

public class LastPanel extends JPanel{

	private static final long serialVersionUID = 6622022380441572410L;
	private MenuLabel label; 
	private GridBagConstraints container;
	
	public LastPanel() {
		super(new GridBagLayout());
		container = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.BLACK);
	}
	
	public void showWinningPanel(Player p) {
		label = new MenuLabel("YOU WON", 16, Color.MAGENTA);
		label.setSecondaryColor(Color.WHITE);
		label.switchBlink();
		container.fill = GridBagConstraints.CENTER;
		container.gridy = 0;
		this.add(label, container);
		
		String text = p.getNickname() + " " + Integer.toString(p.getScore().getScore()) + " pts";
		container.gridy = 1;
		this.add(new MenuLabel(text, 7, Color.GREEN), container);
	}
	
	public void showLosingPanel() {
		label = new MenuLabel("GAME-OVER", 16, Color.BLACK);
		label.setSecondaryColor(Color.RED);
		label.switchBlink();
		container.fill = GridBagConstraints.CENTER;
		container.gridy = 0;
		this.add(label, container);
	}
}
