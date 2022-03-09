package menu.components;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import stage.utils.MainFontLoader;

public class SelectionPanel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2928014517775593930L;
	Font gameFont = MainFontLoader.load();
    
    public SelectionPanel() {
        this.setText("---");
		this.setForeground(Color.green);
		this.setFont(gameFont);
    }	
	

}
