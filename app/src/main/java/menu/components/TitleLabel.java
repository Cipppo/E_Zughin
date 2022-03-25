package menu.components;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import stage.utils.MainFontLoader;

public class TitleLabel extends JLabel{
    
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9143946569687691268L;
	MainFontLoader fontLoader = new MainFontLoader(11);
	Font gameFont = fontLoader.load();
    
    public TitleLabel() {
        this.setText("PANG");
		this.setForeground(Color.magenta);
		this.setFont(gameFont);
    }
}
