package pangGuy.gui;


import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;

/**
 * Makes checks about the position of a character
 */

public class BoundChecker {

    private Pair<Integer, Integer> bounds;

    /**
     * Creates a new BoundChecker.
     * @param bounds a Pair<Integer, Integer> with MAX_X and MAX_Y.
     */
    public BoundChecker(Pair<Integer, Integer>  bounds){
        this.bounds = bounds;
    }

    /**
     * Checks if the next pos is inside of the GUI.
     * @param pos the next character pos.
     * @param width the character width.
     * @param height the character height.
     * @return True if is inside, False otherwise.
     */
    public boolean isInside(EntityPos2D pos ,int width, int height){
        if(pos.getX() >= this.bounds.getX() && pos.getX() + width <= this.bounds.getY()){
            return true;
        }
        return false;
    }

    /**
     * Checks if the Arpion can raise more.
     * @param pos the next arpion position.
     * @return True if it can raise more, False otherwise.
     */
    public boolean isExtendible(EntityPos2D pos){
        if(pos.getY() > 0 ){
            return true;
        }else{
            return false;
        }
    }
    
}
