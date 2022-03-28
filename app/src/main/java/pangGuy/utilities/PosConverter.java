package pangGuy.utilities;

import pangGuy.gui.Actor;


public class PosConverter {
    
    private Pair<Integer> dimensions;
    private Actor actor;

    public PosConverter(Pair<Integer> dimensions, Actor actor){
        this.dimensions = dimensions;
        this.actor = actor;
    }


    private Pos2D getLeftPos(){
        return this.actor.getShape().getPos();
    }


    private Pos2D getRightPos(){
        int x = (this.actor.getShape().getPos().x + this.actor.getShape().getDimensions().getX()) - this.dimensions.getX();
        int y = this.actor.getShape().getPos().y;
        return new Pos2D(x, y);
    }

    public Pos2D getPos(Directions dir){
        if(dir == Directions.RIGHT){
            return getRightPos();
        }else{
            return getLeftPos();
        }
    }
}
