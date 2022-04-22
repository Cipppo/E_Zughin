package stage.components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;

import stage.utils.MainFontLoader;

public class P2ScoreLabel extends JLabel{
    
	private static final long serialVersionUID = 6364855665482369354L;
	MainFontLoader fontLoader = new MainFontLoader();
	Font gameFont = fontLoader.load();

	public P2ScoreLabel() {
        this.setText("1453");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
