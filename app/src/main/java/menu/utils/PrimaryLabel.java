package menu.utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import stage.utils.MainFontLoader;

public class PrimaryLabel extends JLabel{
	
	private static final long serialVersionUID = 6355055982797944606L;
	private MainFontLoader fontLoader = new MainFontLoader(11);
	private Font gameFont = fontLoader.load();
	
	public PrimaryLabel(){
		this.setForeground(Color.MAGENTA);
	}
	
	public void setPSize(int size) {
		this.fontLoader = new MainFontLoader(size);
		this.gameFont = fontLoader.load();
	}
	
	public Font getGameFont() {
		return gameFont;
	}
	
}
