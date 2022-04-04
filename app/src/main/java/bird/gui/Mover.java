package bird.gui;

import bird.utilities.Directions;
import bird.utilities.Pos2D;

public class Mover {
    
    private final Actor actor;
    private final BoundChecker bc;

    public Mover(Actor actor, BoundChecker bc) {
        this.actor = actor;
        this.bc = bc;
    }

    public void move(Pos2D pos, Directions dir) {
        if(bc.isInside(pos, this.actor.getShape().getDimensions().getX(), 
        this.actor.getShape().getDimensions().getY())) {
            this.actor.changeLocation(pos);
        }
    }

    public Pos2D getCurrentPos(){
        return this.actor.getShape().getPos();
    }
}
