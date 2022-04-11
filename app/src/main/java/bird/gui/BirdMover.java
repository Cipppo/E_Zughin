package bird.gui;

import bird.utilities.BirdDirections;
import bird.utilities.BirdPos2D;

public class BirdMover {
    
    private final BirdActor actor;
    private final BirdBoundChecker bc;

    public BirdMover(BirdActor actor, BirdBoundChecker bc) {
        this.actor = actor;
        this.bc = bc;
    }

    public void move(BirdPos2D pos, BirdDirections dir) {
        if(bc.isInside(pos, this.actor.getShape().getDimensions().getX(), 
        this.actor.getShape().getDimensions().getY())) {
            this.actor.changeLocation(pos);
        }
    }

    public BirdPos2D getCurrentPos(){
        return this.actor.getShape().getPos();
    }
}
