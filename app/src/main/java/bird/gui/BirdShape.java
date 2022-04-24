package bird.gui;

import java.awt.Rectangle;
import bird.utilities.BirdDirections;
import pangGuy.utilities.Pair;
import utilities.EntityShape;
import pangGuy.utilities.EntityPos2D;

/**
 * This class models the shape of the bird.
 */
public class BirdShape implements EntityShape {

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
    public BirdShape(EntityPos2D pos, int width, int height, BirdDirections dir){
        r = new Rectangle(pos.getX(), pos.getY(), width, height);
        this.dir = dir;
    }
    
    /**
     * @return
     *          the bird's position
     */
    public EntityPos2D getPos(){
        return new EntityPos2D((int)r.getX(), (int) r.getY());
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