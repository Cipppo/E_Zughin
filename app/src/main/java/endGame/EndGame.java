package endGame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

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
	//private int lives;
	private Timer timer;
	private LastPanel lastPanel;
	
	/**
	 * Constructor with parameters 
	 * @param player    used for knowing data about the player and save it in case of winning with high score
	 * @param lives		used for knowing the lives of the player
	 * @throws FileNotFoundException
	 */
	public EndGame(Player player, boolean win) throws FileNotFoundException {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width*70/100, heigth*70/100);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		this.player = player;
		//this.lives = lives;
		this.lastPanel = new LastPanel();
		this.add(lastPanel);
		simpleTimer();
		timer.start();
	
		if (win) {								//lives greater than 0, winning case
			//this.player.increaseScore(this.lives * 200);	//add 200 extra points for each lives 
			this.players = new Players();
			this.players.Read();
			this.players.add(this.player);
			this.players.Save();							//add the player to players container and saving his data for the
			this.lastPanel.showWinningPanel(this.player);
		}else {												//otherwise losing case
			this.lastPanel.showLosingPanel();
		}
	}
	
	public void simpleTimer() {
		timer = new Timer(8000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	EndGame.this.dispose();
            	}
		});
	}
}
