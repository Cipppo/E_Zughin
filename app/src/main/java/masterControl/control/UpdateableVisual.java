package mergeballs.control;

import java.util.List;
import java.util.Optional;

import ball.physics.SpherePos2D;
import bird.gui.BirdShape;
import pangGuy.utilities.EntityPos2D;
import pangGuy.gui.ArpionComponent;
import pangGuy.gui.HeroComponent;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pair;

/**
 * A class that implement this interface, gives the possibility
 * to call an updatePosition that should delegate the job of refreshing
 * the current gui with new updated position. Also, this interface
 * shows to the outside the bounds of the stage, all the arpions 
 * in game and hero.
 */

public interface UpdateableVisual {
    /**
     * * This method will be called after checking all the possibile collisons
     * beetween arpions/hero and a ball, or arpions/hero and the bird. 
     * Calling it, will cause the GUI to receive updated information regarding 
     * balls, the bird, the arpions and the hero position and status.
     * @param ballPositions
     * @param birdDirection
     * @param birdShape
     */
    void updatePosition(List<SpherePos2D> ballPositions, Directions birdDirection, Optional<BirdShape> birdShape);

    /**
     * Getter for game frame size.
     * @return stageBounds
     *          a pair containing width (X) and height (Y).
     *          
     */
    Pair<Integer, Integer> getBounds();
    
    /**
     * 
     * @return  All in game arpions in the moment the method is called.
     */
    List<ArpionComponent> getArpions();

    /**
     * Temporary by now, because is needed only Hero shape.
     * @return All hero informations (needing by now only the shape of it).
     */
    HeroComponent getHero();

    /**
     * 
     * @return
     *      Hero initial ballPositions at the beginning of the game.
     */
    EntityPos2D getStartPos();
}
