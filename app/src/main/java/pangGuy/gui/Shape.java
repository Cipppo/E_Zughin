package pangGuy.gui;

import java.awt.Rectangle;

import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;
import utilities.EntityShape;
import utilities.FullPair;

/**
 * It stores the position in a 2D space of a 2D entity.
 */


public class Shape implements EntityShape{

    private final Rectangle r;

    /**
     * Create a new Shape.
     * @param pos the position in the 2D space.
     * @param width the width of the entity.
     * @param height the height of the entity.
     */
    public Shape(EntityPos2D pos, int width, int height){
        r = new Rectangle(pos.getX(), pos.getY(), width, height);
    }
    
    @Override
    public EntityPos2D getPos(){
        return new EntityPos2D((int)r.getX(), (int) r.getY());
    }

    @Override
    public FullPair<Integer, Integer> getDimensions(){
        return new Pair<Integer, Integer>((int)r.getWidth(), (int)r.getHeight());
    }
    
    /**
     * Getter for the Rectangle made from the entity specs.
     * @return Rectangle made from the entity specs.
     */
    public Rectangle getRectangle(){
        return this.r;
    }

    /**
     * Assuming that the "head" of the rectangle is the up-left corner, 
     * it returns the down-left corner (Left foot).
     * The method is called in order to position the arpions.
     * @return an EntityPos2D with the left foot coords.
     */
    public EntityPos2D getLeftFoot(){
        EntityPos2D mainPos = this.getPos();
        return new EntityPos2D(mainPos.getX(), mainPos.getY() + (int) this.r.getHeight());
    }

    @Override
    public String toString(){
        return "(" + this.getRectangle().toString() + ")";
    }

}
