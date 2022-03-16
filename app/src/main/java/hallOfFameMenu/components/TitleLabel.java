package hallOfFameMenu.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import stage.utils.MainFontLoader;

public class TitleLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3667606843812512575L;
	MainFontLoader fontLoader = new MainFontLoader(7);
	Font gameFont = fontLoader.load();
	
	public TitleLabel() {
		this.setText("HALL OF FAME");
		this.setForeground(Color.MAGENTA);
		this.setFont(gameFont);
	}
	
}
