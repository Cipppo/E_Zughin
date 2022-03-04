package stage.gui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4255916723363898550L;
	private final JLabel label = new JLabel();
	private final JPanel panel = new JPanel();
	private final int size = 2;
	private final int width;
	private final int heigth;

	public Gui() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		width = CenterOnDeafultScreen().get("width");
		heigth = CenterOnDeafultScreen().get("heigth");
		
		this.setSize(width/size, heigth/size);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel.add(label);
		this.getContentPane().add(panel);
		this.setVisible(true);
		
		
	}
	
	public Map<String, Integer> CenterOnDeafultScreen() {
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int heigth = gd.getDisplayMode().getHeight();
		Map<String, Integer> dimensions = new HashMap<>();
		
		dimensions.put("width", width);
		dimensions.put("heigth", heigth);
		
		return dimensions;
	}
}
