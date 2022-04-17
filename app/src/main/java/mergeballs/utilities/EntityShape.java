package mergeballs.utilities;

/**
 * Models a useful class which can store a component position and his dimensions in the space.
 */


public interface EntityShape {

    /**
     * Getter for the position in space.
     * @return the position in the space under EntityPos2D.
     */
    EntityPos2D getPos();
    
    /**
     * Getter for the component dimensions in space.
     * @return a FullPair<Width, Height>
     */
    FullPair<Integer, Integer> getDimensions();


}