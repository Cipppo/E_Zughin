package ball.gui;

import javax.swing.JPanel;

import powerUp.TimeFreeze;

import java.awt.BorderLayout;
import javax.swing.JButton;
/**
 * Testing control panel for calling major function of Balls.
 */
public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton separateOne;
	private JButton stopAll;
	private JButton resumeAll;
	private JButton timeFreeze;

	@SuppressWarnings("unused")
	private Visualiser visual;
	
	public ControlPanel(Visualiser visual) {
		this.visual = visual;
		
		this.setSize(250, 130);
		this.separateOne = new JButton("Duplicate a ball");
		this.stopAll = new JButton("Stop all Balls");
		this.resumeAll = new JButton("Resume all Balls");
		this.timeFreeze = new JButton("Time Freeze(3 sec)");

		JPanel pane = new JPanel();

		pane.add(this.separateOne, BorderLayout.NORTH);
		//pane.add(this.stopAll, BorderLayout.SOUTH);
		//pane.add(this.resumeAll, BorderLayout.CENTER);
		pane.add(this.timeFreeze, BorderLayout.SOUTH);
		
		this.add(pane);
		
		this.separateOne.addActionListener(t -> {
			visual.duplicatation();
		});
		/*
		this.stopAll.addActionListener(t -> {
			visual.pauseAll();
		});

		this.resumeAll.addActionListener(t -> {
			visual.resumeAll();
		});
		*/

		this.timeFreeze.addActionListener(t -> {
			var tF = new TimeFreeze(this.visual);
			tF.setDuration(3);
			tF.start();
		});
	}
}
