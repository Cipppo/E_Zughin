package endGame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import player.*;
import stage.utils.CenterOnDefaultScreen;

/**
 * Class use for the control of the end of the game
 *
 */
public class EndGame extends JFrame{
	private static final long serialVersionUID = -2322832387479009686L;
	
	private final int width = CenterOnDefaultScreen.center().width;
	private final int heigth = CenterOnDefaultScreen.center().height;
	
	private Player player;
	private Players players;
	private Timer timer;
	private LastPanel lastPanel;
	
	/**
	 * Constructor with parameters 
	 * @param player    used for knowing data about the player and save it in case of winning with high score
	 * @param win		used for knowing if is winning case or not
	 * @param check 	control for not saving multiple time
	 */
	public EndGame(Player player, boolean win, int check) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width*70/100, heigth*60/100);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		this.player = player;
		this.lastPanel = new LastPanel();
		this.add(lastPanel);
		simpleTimer();
		timer.start();
	
		if (win) {											//winning case
			this.lastPanel.showWinningPanel(this.player);
			if (check == 1) {
				this.players = new Players();
				this.players.Read();
				this.players.add(this.player);
				this.players.Sort();
				this.players.Save();	
			}
		}else {												//otherwise losing case
			
			this.lastPanel.showLosingPanel();
		}
	}
	
	/**
	 *  method to dispose the gui after some times
	 */
	public void simpleTimer() {
		timer = new Timer(6000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	EndGame.this.dispose();
            	}
		});
	}
}
