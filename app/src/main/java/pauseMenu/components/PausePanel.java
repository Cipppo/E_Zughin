package pauseMenu.components;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import stage.utils.MainFontLoader;

public class PausePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3943280654281528696L;
	JLabel resumeLabel = new JLabel("ESC: RESUME", SwingConstants.CENTER);
	JLabel exitLabel = new JLabel("ENTER: EXIT THE GAME", SwingConstants.CENTER);
	MainFontLoader fontLoader = new MainFontLoader();
	Font gameFont = fontLoader.load();

	public PausePanel() {
		exitLabel.setFont(gameFont);
		resumeLabel.setFont(gameFont);
		resumeLabel.setVerticalAlignment(JLabel.BOTTOM);
		exitLabel.setVerticalAlignment(JLabel.NORTH);
		resumeLabel.setForeground(Color.WHITE);
		exitLabel.setForeground(Color.WHITE);
		
		this.setBackground(new Color(0,0,0,240));
		this.setLayout(new GridLayout(0, 1));
		this.add(resumeLabel);
        this.add(exitLabel);
        this.setVisible(false);
    }
	
	public boolean getVisibility() {
		return this.isVisible();
	}
    
}