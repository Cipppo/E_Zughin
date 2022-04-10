package mergeballs.gui;

import javax.swing.JPanel;



import java.awt.Graphics;

import java.awt.Toolkit;
import java.awt.Graphics2D;

import java.util.List;

import ball.gui.ImageLoader;

import ball.physics.SpherePos2D;
import pangGuy.gui.PangGuyImageLoader;
import pangGuy.gui.Shape;
import pangGuy.utilities.Directions;

public class VisualPanelTest extends JPanel {

    private List<SpherePos2D> positions;
    private List<Shape> shapes;
    private Shape hShape;
    private int width;
    private int height;
    ImageLoader iLoader;
    private PangGuyImageLoader heroILoader;

    public VisualPanelTest(int width, int height, ImageLoader iLoader, PangGuyImageLoader heroILoader){
        super.setSize(width, height);
        this.width = width;
        this.height = height;
        this.iLoader = iLoader;
        this.heroILoader = heroILoader;
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
                    //System.out.println(shape);
                }
            }
            if(this.hShape != null){
                g2.drawImage(heroILoader.getHeroImage(Directions.LEFT).get(0), this.hShape.getPos().x, this.hShape.getPos().y, this);
            }
        }
        g2.dispose();
        Toolkit.getDefaultToolkit().sync();
    }

    public void updatePositions(List<SpherePos2D> pos, List<Shape> aShapes, Shape hShape){
        positions = pos;
        shapes = aShapes;
        this.hShape = hShape;
        repaint();
    }

}
