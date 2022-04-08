package bird.utilities;

import bird.gui.Actor;

public class PosConverter {
    
    private Pair<Integer> dimensions;
    private Actor actor;

    public PosConverter(Pair<Integer> dimensions, Actor actor){
        this.dimensions = dimensions;
        this.actor = actor;
    }


    private BirdPos2D getLeftPos(){
        return this.actor.getShape().getPos();
    }


    private BirdPos2D getRightPos(){
        int x = (this.actor.getShape().getPos().x + this.actor.getShape().getDimensions().getX()) - this.dimensions.getX();
        int y = this.actor.getShape().getPos().y;
        return new BirdPos2D(x, y);
    }

    public BirdPos2D getPos(Directions dir){
        if(dir == Directions.RIGHT){
            return getRightPos();
        }else{
            return getLeftPos();
        }
    }
}

