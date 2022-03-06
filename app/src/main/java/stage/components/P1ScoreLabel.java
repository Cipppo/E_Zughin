package stage.components;

import javax.swing.JLabel;
import stage.utils.FontLoader;

import java.awt.Color;
import java.awt.Font;

public class P1ScoreLabel extends JLabel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4318974631726686466L;
	Font gameFont = FontLoader.load();

	public P1ScoreLabel() {
        this.setText("123345");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
