package bird.gui;

import bird.utilities.Directions;
import bird.utilities.BirdPos2D;

public class Mover {
    
    private final Actor actor;
    private final BoundChecker bc;

    public Mover(Actor actor, BoundChecker bc) {
        this.actor = actor;
        this.bc = bc;
    }

    public void move(BirdPos2D pos, Directions dir) {
        if(bc.isInside(pos, this.actor.getShape().getDimensions().getX(), 
        this.actor.getShape().getDimensions().getY())) {
            this.actor.changeLocation(pos);
        }
    }

    public BirdPos2D getCurrentPos(){
        return this.actor.getShape().getPos();
    }
}
