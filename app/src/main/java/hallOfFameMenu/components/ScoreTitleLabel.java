package hallOfFameMenu.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import stage.utils.MainFontLoader;

public class ScoreTitleLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643946736922113776L;
	MainFontLoader fontLoader = new MainFontLoader(3);
	Font gameFont = fontLoader.load();
	
	public ScoreTitleLabel() {
		this.setText("SCORE");
		this.setForeground(Color.GREEN);
		this.setFont(gameFont);
	}
}
