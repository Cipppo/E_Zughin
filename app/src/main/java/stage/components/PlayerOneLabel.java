package stage.components;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import stage.utils.CenterOnDefaultScreen;
import stage.utils.FontLoader;

import java.awt.Color;
import java.awt.Font;

public class PlayerOneLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7887201380127912727L;
	Font gameFont = FontLoader.load();
	
	public PlayerOneLabel() {
		this.setText("PLAYER 1");
		this.setVerticalAlignment(SwingConstants.TOP);
		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setForeground(Color.white);
		this.setFont(gameFont);
		}

}
