package ball.gui;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;

import java.util.List;

import ball.physics.Pos2D;

public class Visual extends JFrame {
	private static final long serialVersionUID = 1L;

	private VisualPanel panel;
	
	private static final int WINDOW_SIZE_X = 800;
	private static final int WINDOW_SIZE_Y = 600;

	
	public Visual() {
		setTitle("Bouncing Balls");
        
		setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
		setResizable(false);
		panel = new VisualPanel();
		getContentPane().add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void updatePosition(List<Pos2D> pos) {
		panel.updatePositions(pos);
	}
    
    public class VisualPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		private List<Pos2D> positions;
	    private Font usedFont;
	    
	    public VisualPanel() {
			setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
			usedFont = new Font("Verdana", Font.PLAIN, 24);
		}

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
    		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    		g2.clearRect(0, 0, WINDOW_SIZE_X, WINDOW_SIZE_Y);
			
            synchronized (this) {
				if (positions != null) {
					for(final var position : positions) {
						int x = (int)( position.x * WINDOW_SIZE_X );
						int y = (int)( position.y * WINDOW_SIZE_Y - 80 );
						//System.out.println("EFFECTIVE-POSITION (" + x + ", " + y + ")");
						g.fillOval(x, y, 50, 50);
					}
				}
			}

			g2.setFont(usedFont);
			g2.setColor(Color.RED);
		}

		public void updatePositions(List<Pos2D> pos) {
		    positions = pos;
			repaint();
		}
    }
}

