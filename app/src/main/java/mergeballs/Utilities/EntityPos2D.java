package mergeballs.utilities;

/**
 * Simple POJO class useful to store 2 dimensions positions.
 */


public class EntityPos2D {
    
    public int x;
    public int y;

    /**
     * Create a new Point in the field.
     * @param x as the X position 
     * @param y as the Y position
     */
    public EntityPos2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return a string containing the X and Y coords.
     */
    @Override
    public String toString(){
        return "(x = " + this.x + "| y = " + this.y + ")" ;
    }

}
