package stage.components;

import javax.swing.JPanel;
import java.awt.CardLayout;

import bird.controller.BirdConstraintCheck;
import bird.controller.BirdRunner;
import bird.utilities.BirdVisual;
import pauseMenu.components.ExitButton;
import pauseMenu.components.PauseButton;
import pauseMenu.components.PausePanel;

import java.awt.Color;

public class MainPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5567586066880648121L;
	private PausePanel pausePanel = new PausePanel();
	private final BirdVisual visual = new BirdVisual(this);
	private final BirdConstraintCheck checker = new BirdConstraintCheck();
	private final BirdRunner runner = new BirdRunner(this, checker);

	
	public MainPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(new CardLayout());
		new PauseButton(this, pausePanel, visual);
		new ExitButton(this, pausePanel);
	}

	public BirdRunner getBirdRunner() {
		return this.runner;
	}

}
