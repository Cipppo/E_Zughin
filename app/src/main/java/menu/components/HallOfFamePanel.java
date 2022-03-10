package menu.components;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import stage.utils.MainFontLoader;

public class HallOfFamePanel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5582360522433197786L;
	MainFontLoader fontLoader = new MainFontLoader(4);
	Font gameFont = fontLoader.load();
    
    public HallOfFamePanel() {
        this.setText("HALL OF FAME");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }

}
