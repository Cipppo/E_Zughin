package stage.components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;

import stage.utils.MainFontLoader;

public class PlayerTwoLabel extends JLabel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7671139190971480369L;
	private final Font gameFont = MainFontLoader.load();
	
	public PlayerTwoLabel() {
		this.setText("PLAYER 2");
		this.setForeground(Color.white);
		this.setFont(gameFont);
		}
}
