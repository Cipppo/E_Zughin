package bird.gui;

import javax.swing.JLabel;

import bird.utilities.BirdDirections;
import bird.utilities.BirdPNGLoader;
import bird.utilities.BirdPos2D;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * This class is the bird itself. It defines his dimension thanks to the shape and it can
 * change the bird's position.
 */
public class BirdActor extends JLabel{

	private static final long serialVersionUID = 1967410748214691856L;
    
	private BirdShape s;
    private final BirdPNGLoader iLoader = new BirdPNGLoader();

    /**
     * Constructor that define the bird's dimension.
     * @param s
     *          bird's shape.
     */
    public BirdActor(BirdShape s){
        this.s = s;
        
        super.setBounds(this.s.getRectangle());
        super.setOpaque(false);
        
    }
    
    /**
     * This method changes the position of the bird to ne new desired position.
     * @param pos
     *          new position.
     */
    public void changeLocation(BirdPos2D pos){

        super.setLocation(pos.x, pos.y);
        this.s = new BirdShape(pos, this.s.getDimensions().getX(), 
        this.s.getDimensions().getY(), this.getShape().getDireciton());  
    }

    public BirdShape getShape(){
        return this.s;
    }

    /**
     * Thanks to this method the bird is being paint correctly on the frame depending on his direction.
     */
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(iLoader.getBirdImage(this.getShape().getDireciton() == BirdDirections.RIGHT ? BirdDirections.RIGHT : BirdDirections.LEFT, s.getPos()), 
                0, 0, null);

        g2.dispose();
    }
}
