package stage.components;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import stage.utils.MainFontLoader;

/**
 * Initial view of the life panel.
 */
public class LifeLabel extends JLabel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -8126589719155813194L;
	MainFontLoader fontLoader = new MainFontLoader();
	Font gameFont = fontLoader.load();
    
	/**
	 * Sets the initial view of the field.
	 */
    public LifeLabel() {
        this.setText("LIFES: 3");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
