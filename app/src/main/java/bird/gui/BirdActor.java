package bird.gui;

import bird.utilities.BirdDirections;
import stage.utils.CenterOnDefaultScreen;
import pangGuy.utilities.EntityPos2D;

/**
 * This class is the bird itself. It defines his dimension thanks to the shape and it can
 * change the bird's position.
 */
public class BirdActor{

    private static final int WIDTH = CenterOnDefaultScreen.center().width*3/100;
    private static final int HEIGHT = CenterOnDefaultScreen.center().width*3/100;
    
	private BirdShape s;
    private final BirdDirections dir;

    /**
     * Constructor that define the bird's dimension.
     * @param s
     *          bird's shape.
     */
    public BirdActor(EntityPos2D startPos, BirdDirections dir){
        this.dir = dir;
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

    /**
     * @return
     *      the shape of the bird
     */
    public BirdShape getShape(){
        return this.s;
    }
}

