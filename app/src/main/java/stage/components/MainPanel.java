package stage.components;

import javax.swing.JPanel;

import bird.utilities.BirdVisual;
import pauseMenu.components.ExitButton;
import pauseMenu.components.PauseButton;
import pauseMenu.components.PausePanel;

import java.awt.BorderLayout;
import java.awt.Color;

public class MainPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5567586066880648121L;
	private TimerLabel timer = new TimerLabel();
	private PausePanel pausePanel = new PausePanel();
	private final BirdVisual visual = new BirdVisual(this);

	
	public MainPanel() {
		this.setBackground(Color.WHITE);
		this.add(pausePanel, BorderLayout.CENTER);
		new PauseButton(this, pausePanel, timer, visual);
		new ExitButton(this, pausePanel);
	}

	public BirdVisual getVisual() {
		return this.visual;
	}

}
