package bird.gui;

import bird.utilities.BirdDirections;
import bird.utilities.BirdPNGLoader;
import mergeballs.utilities.EntityPos2D;
import stage.utils.CenterOnDefaultScreen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * This class is the bird itself. It defines his dimension thanks to the shape and it can
 * change the bird's position.
 */
public class BirdActor{

    private static final int WIDTH = CenterOnDefaultScreen.center().width*3/100;
    private static final int HEIGHT = CenterOnDefaultScreen.center().width*3/100;
    
	private BirdShape s;
    private final BirdDirections dir = this.randomDirectionChooser();
    private final Random random = new Random();
    private final BirdPNGLoader iLoader = new BirdPNGLoader();

    /**
     * Constructor that define the bird's dimension.
     * @param s
     *          bird's shape.
     */
    public BirdActor(EntityPos2D startPos){
        this.s = new BirdShape(startPos, WIDTH, HEIGHT, dir);
        
    }
    
    /**
     * This method changes the position of the bird to ne new desired position.
     * @param pos
     *          new position.
     */
    public void changeLocation(EntityPos2D pos){
        this.s = new BirdShape(pos, WIDTH, HEIGHT, dir);
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

    public BirdDirections randomDirectionChooser() {
        if(random.nextInt(2) == 0) {
            return BirdDirections.RIGHT;
        } else {
            return BirdDirections.LEFT;
        }
    }
}

