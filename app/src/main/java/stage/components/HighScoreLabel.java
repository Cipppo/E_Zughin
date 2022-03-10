package stage.components;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import stage.utils.MainFontLoader;

public class HighScoreLabel extends JLabel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -8126589719155813194L;
	MainFontLoader fontLoader = new MainFontLoader();
	Font gameFont = fontLoader.load();
    
    public HighScoreLabel() {
        this.setText("HI: 100000");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
