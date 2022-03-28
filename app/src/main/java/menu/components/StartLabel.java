package menu.components;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import stage.utils.MainFontLoader;

public class StartLabel extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8430588428621513653L;
	MainFontLoader fontLoader = new MainFontLoader(4);
	Font gameFont = fontLoader.load();
    
    public StartLabel() {
        this.setText("START");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
