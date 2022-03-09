package menu.components;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import stage.utils.MainFontLoader;

public class StartPanel extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8430588428621513653L;
	Font gameFont = MainFontLoader.load();
    
    public StartPanel() {
        this.setText("START");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
