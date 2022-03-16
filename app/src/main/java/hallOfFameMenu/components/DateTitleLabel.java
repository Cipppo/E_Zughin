package hallOfFameMenu.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import stage.utils.MainFontLoader;

public class DateTitleLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7913907843294692173L;
	MainFontLoader fontLoader = new MainFontLoader(3);
	Font gameFont = fontLoader.load();
	
	public DateTitleLabel() {
		this.setText("DATE");
		this.setForeground(Color.GREEN);
		this.setFont(gameFont);
	}
}
