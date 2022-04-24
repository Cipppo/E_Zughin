package stage.components;

import javax.swing.JLabel;
import stage.utils.MainFontLoader;

import java.awt.Color;
import java.awt.Font;

/**
 * Initial view of the score panel.
 */
public class P1ScoreLabel extends JLabel{

	private static final long serialVersionUID = -4318974631726686466L;
	MainFontLoader fontLoader = new MainFontLoader();
	Font gameFont = fontLoader.load();

	/**
	 * Sets the initial view of the field.
	 */
	public P1ScoreLabel() {
        this.setText("0");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
