package ball.gui;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

import java.awt.Graphics2D;

import java.util.List;

import ball.physics.SpherePos2D;
import pangGuy.utilities.EntityPos2D;
import pangGuy.gui.Shape;

public class Visual extends JFrame implements Updateable {
	private static final long serialVersionUID = 1L;

	private VisualPanel panel;
	private BallImageLoader iLoader;
	
	private static final int WINDOW_SIZE_X = 800;
	private static final int WINDOW_SIZE_Y = 600;

	
	public Visual() {
		setTitle("Bouncing Balls");
		this.iLoader = new BallImageLoader();
		setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
		setResizable(false);
		panel = new VisualPanel();
		this.add(panel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void updatePosition(List<SpherePos2D> pos) {
		panel.updatePositions(pos);
	}
    
    public class VisualPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private List<SpherePos2D> positions;

		private Shape enemy;
	    
		public VisualPanel() {
			setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
			this.enemy = new Shape(new EntityPos2D(WINDOW_SIZE_X / 2, WINDOW_SIZE_Y / 2), 60, 40);
		}

	    public void paint(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g;
	        g2.clearRect(0, 0, WINDOW_SIZE_X, WINDOW_SIZE_Y);

	        synchronized (this) {
	            if (positions != null) {
	                for(final var position : positions) {
	                    int x = (int)( position.getX() * WINDOW_SIZE_X );
	                    int y = (int)( position.getY() * WINDOW_SIZE_Y );
						g2.drawImage(iLoader.getBallImage(position.getDimension()), x, y, this);
	                }
	            }
	        }
			g2.fillRect(this.enemy.getPos().getX(), this.enemy.getPos().getY(), 
						this.enemy.getDimensions().getX(), this.enemy.getDimensions().getY());
			g2.dispose();
			Toolkit.getDefaultToolkit().sync();
	    }

	    public void updatePositions(List<SpherePos2D> pos) {
	        positions = pos;
	        repaint();
	    }
		
		public Shape getGuy() {
			return this.enemy;
		}
    }
	@Override
    public Shape getGuy() {
        return panel.getGuy();
    }
}

