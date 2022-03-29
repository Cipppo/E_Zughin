package pangGuy.gui;

import pangGuy.gun.*;

import pangGuy.utilities.*;

public class Moover {

    private final Actor actor;
    private final Gun gun;
    private final Gun gun2;
    private final BoundChecker bc;

    public Moover(Actor actor, Gun gun, Gun gun2, BoundChecker bc){
        this.actor = actor;
        this.gun = gun;
        this.gun2 = gun2;
        this.bc = bc;
    }

    public void move(Pos2D pos, Directions dir){
        if(bc.isInside(pos, this.actor.getShape().getDimensions().getX(),
        this.actor.getShape().getDimensions().getY())){
            this.actor.changeLocation(pos);
            this.gun.changeLocation(pos);
            this.gun.changeDir(dir);
            this.gun2.changeLocation(pos);
            this.gun2.changeDir(dir);
        }
    }

    public Pos2D getCurrentPos(){
        return this.actor.getShape().getPos();
    }
    
}
