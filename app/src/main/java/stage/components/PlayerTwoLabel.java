package stage.components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;

import stage.utils.FontLoader;

public class PlayerTwoLabel extends JLabel{
    
    private final Font gameFont = FontLoader.load();
	
	public PlayerTwoLabel() {
		this.setText("PLAYER 2");
		this.setForeground(Color.white);
		this.setFont(gameFont);
		}
}
