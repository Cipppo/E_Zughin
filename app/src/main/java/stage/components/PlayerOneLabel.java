package stage.components;

import javax.swing.JLabel;
import stage.utils.MainFontLoader;

import java.awt.Color;
import java.awt.Font;

public class PlayerOneLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7887201380127912727L;
	MainFontLoader fontLoader = new MainFontLoader();
	Font gameFont = fontLoader.load();
	
	public PlayerOneLabel() {
		this.setText("PLAYER 1");
		this.setForeground(Color.white);
		this.setFont(gameFont);
		}

}
