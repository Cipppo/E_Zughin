package menu.components;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import stage.utils.MainFontLoader;

public class TitlePanel extends JLabel{
    
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9143946569687691268L;
	Font gameFont = MainFontLoader.load();
    
    public TitlePanel() {
        this.setText("PANG");
		this.setForeground(Color.magenta);
		this.setFont(gameFont);
    }
}
