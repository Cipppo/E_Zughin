package mergeballs.gui;

import javax.swing.JPanel;
import java.awt.Graphics;

import java.awt.Toolkit;
import java.awt.Graphics2D;

import java.util.List;

import ball.gui.ImageLoader;

import ball.physics.SpherePos2D;
import pangGuy.gui.Shape;

public class VisualPanelTest extends JPanel {

    private List<SpherePos2D> positions;
    private List<Shape> shapes;
    private int width;
    private int height;
    ImageLoader iLoader;

    public VisualPanelTest(int width, int height, ImageLoader iLoader){
        super.setSize(width, height);
        this.width = width;
        this.height = height;
        this.iLoader = iLoader;
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, this.width, this.height);

        synchronized(this){
            if(this.positions != null){
                for(final var position : positions){
                    int x = (int)(position.x * this.width);
                    int y = (int)(position.y * this.height);
                    g2.drawImage(iLoader.getBallImage(position.getDimension()), x, y, this);
                }
            }
            if(this.shapes != null){
                for(final var shape : shapes){
                    g2.fillRect(shape.getPos().x, shape.getPos().y, shape.getDimensions().getX(), shape.getDimensions().getY());
                    System.out.println(shape);
                }
            }
        }
        g2.dispose();
        Toolkit.getDefaultToolkit().sync();
    }

    public void updatePositions(List<SpherePos2D> pos, List<Shape> aShapes){
        positions = pos;
        shapes = aShapes;
        repaint();
    }

}
