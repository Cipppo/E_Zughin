package pangGuy.utilities;

import pangGuy.gui.Actor;


public class PosConverter {
    
    private Pair<Integer, Integer> dimensions;
    private Actor actor;

    public PosConverter(Pair<Integer, Integer> dimensions, Actor actor){
        this.dimensions = dimensions;
        this.actor = actor;
    }


    private Pos2D getLeftPos(){
        return this.actor.getShape().getLeftFoot();
    }


    private Pos2D getRightPos(){
        int x = (this.actor.getShape().getLeftFoot().x + (int) this.actor.getShape().getDimensions().getX()) - this.dimensions.getX();
        int y = this.actor.getShape().getLeftFoot().y;
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
