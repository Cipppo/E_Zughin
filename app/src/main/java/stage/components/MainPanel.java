package stage.components;

import javax.swing.JPanel;

import pauseMenu.components.ExitButton;
import pauseMenu.components.PauseButton;
import pauseMenu.components.PausePanel;

import java.awt.BorderLayout;

public class MainPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5567586066880648121L;
	private TimerLabel timer = new TimerLabel();
	private PausePanel pausePanel = new PausePanel();
	
	public MainPanel() {
		//this.setBackground(Color.gray);
		this.setLayout(new BorderLayout());
		this.add(timer, BorderLayout.NORTH);
		this.add(pausePanel, BorderLayout.CENTER);
		new PauseButton(this, pausePanel, timer);
		new ExitButton(this, pausePanel);
	}

}
