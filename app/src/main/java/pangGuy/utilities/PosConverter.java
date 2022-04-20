package pangGuy.utilities;


import pangGuy.gui.Shape;

/**
 * This class is used in order to position properly the arpions.
 */

public class PosConverter {
    
    private Pair<Integer, Integer> dimensions;
    private Shape heroShape;

    /**
     * Creates a new PosConverter
     * @param dimensions the dimensions of the Arpion.
     * @param heroShape the hero Shape.
     */
    public PosConverter(Pair<Integer, Integer> dimensions, Shape heroShape){
        this.dimensions = dimensions;
        this.heroShape = heroShape;
    }

    /**
     * Compute the coords where the arpion have to move if the direction of the Hero is Left.
     * @return the coords of the left position.
     */
    private EntityPos2D getLeftPos(){
        return this.heroShape.getLeftFoot();
    }

    /**
     * Compute the coords where the arpion have to lay if the direction of the Hero is Right.
     * @return the coords of the Right position.
     */
    private EntityPos2D getRightPos(){
        int x = (this.heroShape.getLeftFoot().getX() + (int) this.heroShape.getDimensions().getX()) - this.dimensions.getX();
        int y = this.heroShape.getLeftFoot().getY();
        return new EntityPos2D(x, y);
    }

    /**
     * Compute the next position based on the given Direction.
     * @param dir the Hero direction.
     * @return the coords where the Arpion has to lay based on the given Hero Direction.
     */
    public EntityPos2D getPos(Directions dir){
        if(dir == Directions.RIGHT){
            return getRightPos();
        }else{
            return getLeftPos();
        }
    }
}
