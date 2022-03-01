package ball.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ControlPanel extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton separateOne;
	@SuppressWarnings("unused")
	private Visualiser visual;
	
	public ControlPanel(Visualiser visual) {
		this.visual = visual;
		
		this.setTitle("Control Panel");
		this.setSize(250, 60);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.separateOne = new JButton("Duplicate a ball");
		
		JPanel pane = new JPanel();
		pane.add(this.separateOne);
		this.add(pane);
		
		this.separateOne.addActionListener(t -> {
			visual.duplicatation();
		});
	}
}
