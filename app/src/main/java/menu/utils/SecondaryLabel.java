package menu.utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import stage.utils.MainFontLoader;

public class SecondaryLabel extends JLabel{

	private static final long serialVersionUID = 6456543380096568746L;
	private MainFontLoader fontLoader = new MainFontLoader(7);
	private Font gameFont = fontLoader.load();
	
	public SecondaryLabel() {
		this.setForeground(Color.GREEN);
	}
	
	public void setSSize(int size) {
		this.fontLoader = new MainFontLoader(size);
		this.gameFont = fontLoader.load();
	}
	
	public Font getGameFont() {
		return gameFont;
	}
	
}
