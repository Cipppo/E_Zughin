package bird.gui;

import bird.utilities.BirdDirections;
import pangGuy.utilities.EntityPos2D;
/**
 * Checks if the bird is inside the stage and than moves it.
 */
public class BirdMover {
    
    private final BirdActor actor;
    private final BirdBoundChecker bc;

    /**
     * Constructor that initializes the bird and the bounds checker.
     * @param actor
     *          bird.
     * @param bc
     *          bound checker.
     */
    public BirdMover(BirdActor actor, BirdBoundChecker bc) {
        this.actor = actor;
        this.bc = bc;
    }

    /**
     * Moves the bird to the desired position.
     * @param pos
     *          position to move the bird.
     * @param dir
     *          direction the bird is flying.
     */
    public void move(EntityPos2D pos, BirdDirections dir) {
        if(bc.isInside(pos, this.actor.getShape().getDimensions().getX(), 
        this.actor.getShape().getDimensions().getY())) {
            this.actor.changeLocation(pos);
        }
    }

    /**
     * @return
     *          the current position of the bird
     */
    public EntityPos2D getCurrentPos(){
        return this.actor.getShape().getPos();
    }
}
