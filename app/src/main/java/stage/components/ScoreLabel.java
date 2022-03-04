package stage.components;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import stage.utils.CenterOnDefaultScreen;

import java.awt.Color;
import java.awt.Font;

public class ScoreLabel extends JLabel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4318974631726686466L;

	public ScoreLabel() {
        this.setText("123345");
		this.setVerticalAlignment(SwingConstants.CENTER);
        this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setForeground(Color.white);
		this.setFont(new Font("Retro Gaming", Font.BOLD, CenterOnDefaultScreen.center().height*2/100));
    }
}
