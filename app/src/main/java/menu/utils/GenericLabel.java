package menu.utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import stage.utils.MainFontLoader;

public class GenericLabel extends JLabel{
	
	private static final long serialVersionUID = 8542139746159248982L;
	private MainFontLoader fontLoader = new MainFontLoader(3);
	private Font gameFont = fontLoader.load();
	
	public GenericLabel(){
		this.setForeground(Color.WHITE);
	}
	
	public void setGSize(int size) {
		this.fontLoader = new MainFontLoader(size);
		this.gameFont = fontLoader.load();
	}
	
	public Font getGameFont() {
		return gameFont;
	}
	
}
