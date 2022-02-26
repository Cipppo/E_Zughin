package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


public class CenterOnDeafultScreen extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4575157663500557803L;

	public CenterOnDeafultScreen(int size) {
		
		JLabel label = new JLabel("Hello World!");
		JPanel panel = new JPanel();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width/size, height/size);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel.add(label);
		this.getContentPane().add(panel);
		
		this.setVisible(true);
	}

}