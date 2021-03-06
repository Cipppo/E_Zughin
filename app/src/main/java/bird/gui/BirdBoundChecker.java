package bird.gui;

import pangGuy.utilities.Pair;
import pangGuy.utilities.EntityPos2D;

/**
 * This class checks if the position of the bird is out of the stage bounds or not.
 */
public class BirdBoundChecker {

    private Pair<Integer, Integer> x;
    private Pair<Integer, Integer> y;

    /**
     * Initializes the bounds with the stage's ones
     * 
     * @param x
     *          abscissas' bounds, lefter and righter.
     * @param y
     *          ordinates' bounds, upper and lower.
     */
    public BirdBoundChecker(Pair<Integer, Integer> x, Pair<Integer, Integer> y){
        this.x = x;
        this.y = y;
    }


    /**
     * Checks if the bird's position is inside the bounds.
     * 
     * @param pos
     *          bird's position.
     * @param width
     *          bird's width.
     * @param height
     *          birds's height.
     * @return
     *          if it's inside or outside.
     */
    public boolean isInside(EntityPos2D pos ,int width, int height){
        if (pos.getX() >= this.x.getX() && pos.getX() + width <= this.x.getY()){
            if (pos.getY() >= this.y.getX() && pos.getY() + height <= this.y.getY()){
                return true;
            }
        }
        return false;
    }

    /**
     * @return
     *          the abscissa's pair.
     */
    public Pair<Integer, Integer> getXPair() {
        return this.x;
    }

    /**
     * @return
     *          the ordinate's pair.
     */
    public Pair<Integer, Integer> getYPair() {
        return this.y;
    }
    
}
