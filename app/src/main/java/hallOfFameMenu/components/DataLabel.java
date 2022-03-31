package hallOfFameMenu.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import stage.utils.MainFontLoader;

public class GenericLabel extends Label{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8922618576263627976L;
	MainFontLoader fontLoader = new MainFontLoader(3);
	Font gameFont = fontLoader.load();
	
	public GenericLabel(String text) {
		this.setText(text);
		this.setForeground(Color.WHITE);
		this.setFont(gameFont);
	}
}
