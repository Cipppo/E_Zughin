package stage.components;

import javax.swing.JPanel;

import java.awt.CardLayout;

import bird.controller.BirdConstraintCheck;
import bird.controller.BirdRunner;
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
	private final BirdConstraintCheck checker = new BirdConstraintCheck();
	private final BirdRunner runner = new BirdRunner(this, checker);

	
	public MainPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(new CardLayout());
		new PauseButton(this, pausePanel, this.runner.getBirdVisual());
		new ExitButton(this, pausePanel);
		this.setVisible(true);
	}

	public BirdRunner getBirdRunner() {
		return this.runner;
	}

}
