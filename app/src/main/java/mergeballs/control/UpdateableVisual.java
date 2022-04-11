package mergeballs.control;

import java.util.List;

import ball.physics.SpherePos2D;
import pangGuy.gui.ArpionComponent;
import pangGuy.gui.HeroComponent;
import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;
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
     */
    void updatePosition(List<SpherePos2D> pos);

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
    Pos2D getStartPos();
}
