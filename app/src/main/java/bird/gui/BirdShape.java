package bird.gui;

import java.awt.Rectangle;
import bird.utilities.BirdDirections;
import pangGuy.utilities.Pair;
import bird.utilities.BirdPos2D;

/**
 * This class models the shape of the bird.
 */
public class BirdShape {

    private final Rectangle r;
    private final BirdDirections dir;


    /**
     * This constructor creats a new rectangle for the bird.
     * 
     * @param pos
     *          bird's position.
     * @param width
     *          bird's width.
     * @param height
     *          bird's height.
     * @param dir
     *          bird's direction.
     */
    public BirdShape(BirdPos2D pos, int width, int height, BirdDirections dir){
        r = new Rectangle(pos.x, pos.y, width, height);
        this.dir = dir;
    }
    
    /**
     * @return
     *          the bird's position
     */
    public BirdPos2D getPos(){
        return new BirdPos2D((int)r.getX(), (int) r.getY());
    }

    /**
     * @return
     *          the bird's dimension.
     */
    public Pair<Integer, Integer> getDimensions(){
        return new Pair<Integer, Integer>((int)r.getWidth(), (int)r.getHeight());
    }
    
    /**
     * @return
     *          the bird's rectangle.
     */
    public Rectangle getRectangle(){
        return this.r;
    }

    /**
     * @return
     *      the bird's direction.
     */
    public BirdDirections getDireciton() {
        return this.dir;
    }

    @Override
    public String toString(){
        return "(" + this.getRectangle().toString() + ")";
    }

}