package ball.gui;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

import java.awt.Graphics2D;

import java.util.List;

import ball.physics.SpherePos2D;
import ball.testing.SquaredEnemy;

public class Visual extends JFrame implements Updateable {
	private static final long serialVersionUID = 1L;

	private VisualPanel panel;
	private ImageLoader iLoader;
	
	private static final int WINDOW_SIZE_X = 800;
	private static final int WINDOW_SIZE_Y = 600;

	
	public Visual() {
		setTitle("Bouncing Balls");
		this.iLoader = new ImageLoader();
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

		private SquaredEnemy enemy;
	    
		public VisualPanel() {
			setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
			this.enemy = new SquaredEnemy(WINDOW_SIZE_X / 2, WINDOW_SIZE_Y / 2, 60, 30);
		}

	    public void paint(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g;
	        g2.clearRect(0, 0, WINDOW_SIZE_X, WINDOW_SIZE_Y);

	        synchronized (this) {
	            if (positions != null) {
	                for(final var position : positions) {
	                    int x = (int)( position.x * WINDOW_SIZE_X );
	                    int y = (int)( position.y * WINDOW_SIZE_Y );
						g2.drawImage(iLoader.getBallImage(position.getDimension()), x, y, this);
	                }
	            }
	        }
			g2.fillRect(this.enemy.getPosition().x, this.enemy.getPosition().y, 
						this.enemy.getDimension().getX(), this.enemy.getDimension().getY());
			g2.dispose();
			Toolkit.getDefaultToolkit().sync();
	    }

	    public void updatePositions(List<SpherePos2D> pos) {
	        positions = pos;
	        repaint();
	    }

		public SquaredEnemy getGuy() {
			return this.enemy;
		}
    }

    public SquaredEnemy getGuy() {
        return panel.getGuy();
    }
}

