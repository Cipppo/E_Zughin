package stage.components;

import javax.swing.JLabel;
import stage.utils.MainFontLoader;

import java.awt.Color;
import java.awt.Font;

/**
 * Stage name label.
 */
public class StageNameLabel extends JLabel{

	private static final long serialVersionUID = -5278165653375956068L;
	MainFontLoader fontLoader = new MainFontLoader();
	Font gameFont = fontLoader.load();
    
	/**
	 * Sets the stage name label.
	 */
    public StageNameLabel() {
        this.setText("MT. KEIRIN");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
