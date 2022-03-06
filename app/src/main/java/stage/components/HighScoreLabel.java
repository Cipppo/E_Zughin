package stage.components;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import stage.utils.FontLoader;

public class HighScoreLabel extends JLabel{
    
    Font gameFont = FontLoader.load();
    
    public HighScoreLabel() {
        this.setText("HI: 100000");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
