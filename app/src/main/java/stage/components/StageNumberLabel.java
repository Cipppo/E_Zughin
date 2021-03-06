package stage.components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;

import stage.utils.MainFontLoader;

/**
 * Stage number label.
 */
public class StageNumberLabel extends JLabel{
    
	private static final long serialVersionUID = -5270799471560968663L;
	MainFontLoader fontLoader = new MainFontLoader();
	Font gameFont = fontLoader.load();
    
	/**
	 * Sets the stage number label.
	 */
    public StageNumberLabel(){
        this.setText("10-28 STAGE");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
