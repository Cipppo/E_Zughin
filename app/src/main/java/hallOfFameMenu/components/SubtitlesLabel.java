package hallOfFameMenu.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import stage.utils.MainFontLoader;

public class NicknameTitleLabel extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1953141241408051372L;
	MainFontLoader fontLoader = new MainFontLoader(3);
	Font gameFont = fontLoader.load();
	
	public NicknameTitleLabel() {
		this.setText("NICKNAME");
		this.setForeground(Color.GREEN);
		this.setFont(gameFont);
	}
}
