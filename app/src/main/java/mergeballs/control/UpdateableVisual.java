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
import powerUp.PowerUpEntity;

/**
 * Models a controller that stores arpions, the Hero and all their informations.
 * The class that implement this interface will be used by a ball handler, that
 * constantly checks if there are collisons beetween a ball and arpions/hero.
 */

public interface UpdateableVisual {
    /**
     * This method will be called after checking all the possibile collisons
     * beetween arpions/hero and a ball. 
     * Calling it, will cause the GUI to receive updated information regarding 
     * aprions, balls and hero position.
     * @param position
     *      a list of spherical position (the balls)
     * @param dir 
     *      the direction of the main character
     * @param pUp
     *      the powerup which we are gonna display
     */
    void updatePosition(List<SpherePos2D> position, Directions dir, Optional<PowerUpEntity> pUp, Optional<BirdShape> bShape);

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
     *      Hero initial position at the beginning of the game.
     */
    EntityPos2D getStartPos();
}
