package mergeballs.utilities;

import pangGuy.utilities.EntityPos2D;
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
     * @return a {@link mergeballs.utilities.FullPair} of (width, height)
     */
    FullPair<Integer, Integer> getDimensions();


}
