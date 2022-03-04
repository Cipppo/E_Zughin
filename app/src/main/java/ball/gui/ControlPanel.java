package ball.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class ControlPanel extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton separateOne;
	private JButton stopAll;
	private JButton resumeAll;

	@SuppressWarnings("unused")
	private Visualiser visual;
	
	public ControlPanel(Visualiser visual) {
		this.visual = visual;
		
		this.setTitle("Control Panel");
		this.setSize(250, 130);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.separateOne = new JButton("Duplicate a ball");
		this.stopAll = new JButton("Stop all Balls");
		this.resumeAll = new JButton("Resume all Balls");
		
		JPanel pane = new JPanel();
		pane.add(this.separateOne, BorderLayout.NORTH);
		pane.add(this.stopAll, BorderLayout.SOUTH);
		pane.add(this.resumeAll, BorderLayout.CENTER);
		this.add(pane);
		
		this.separateOne.addActionListener(t -> {
			visual.duplicatation();
		});

		this.stopAll.addActionListener(t -> {
			visual.pauseAll();
		});

		this.resumeAll.addActionListener(t -> {
			visual.resumeAll();
		});
	}
}
