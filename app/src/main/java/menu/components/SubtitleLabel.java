package menu.components;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import stage.utils.MainFontLoader;

public class SubtitlePanel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5425263161796580824L;
	MainFontLoader fontLoader = new MainFontLoader(7);
	Font gameFont = fontLoader.load();
	    
    public SubtitlePanel() {
        this.setText("ARCADE RETRO-GAME");
		this.setForeground(Color.magenta);
		this.setFont(gameFont);
    }
	
}
