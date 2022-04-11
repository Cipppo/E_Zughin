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
	private final JLabel resumeLabel = new JLabel("ESC: RESUME", SwingConstants.CENTER);
	private final JLabel exitLabel = new JLabel("ENTER: EXIT THE GAME", SwingConstants.CENTER);
	private final MainFontLoader fontLoader = new MainFontLoader();
	private final Font gameFont = fontLoader.load();

	public PausePanel() {
		exitLabel.setFont(gameFont);
		resumeLabel.setFont(gameFont);
		resumeLabel.setVerticalAlignment(JLabel.BOTTOM);
		exitLabel.setVerticalAlignment(JLabel.NORTH);
		resumeLabel.setForeground(Color.WHITE);
		exitLabel.setForeground(Color.WHITE);
		
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(0, 1));
		this.add(resumeLabel);
        this.add(exitLabel);
        this.setVisible(false);
    }
	
	public boolean getVisibility() {
		return this.isVisible();
	}
    
}