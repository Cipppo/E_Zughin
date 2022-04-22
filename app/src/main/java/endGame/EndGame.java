package endGame;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

import player.*;
import stage.utils.CenterOnDefaultScreen;

public class EndGame extends JFrame{
	private static final long serialVersionUID = -2322832387479009686L;
	
	private final int width = CenterOnDefaultScreen.center().width;
	private final int heigth = CenterOnDefaultScreen.center().height;
	
	private Player player;
	private Players players;
	private int lives;
	private LastPanel lastPanel;
	
	
	public EndGame(Player player, int lives) throws FileNotFoundException {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width*70/100, heigth*70/100);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		this.player = player;
		this.lives = lives;
		this.lastPanel = new LastPanel();
		this.add(lastPanel);
		
		if (this.lives > 0) {
			this.player.increaseScore(this.lives * 200);
			this.players = new Players();
			this.players.Read();
			this.players.add(this.player);
			this.players.Save();
			
			this.lastPanel.showWinningPanel(this.player);
		}else {
			this.lastPanel.showLosingPanel();
		}
	}
}
