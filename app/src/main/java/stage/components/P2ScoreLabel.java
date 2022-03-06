package stage.components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;

import stage.utils.FontLoader;

public class P2ScoreLabel extends JLabel{
    
    Font gameFont = FontLoader.load();

	public P2ScoreLabel() {
        this.setText("1453");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
