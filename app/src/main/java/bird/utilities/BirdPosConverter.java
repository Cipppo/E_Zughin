package bird.utilities;

import bird.gui.BirdActor;
import pangGuy.utilities.Pair;

public class BirdPosConverter {
    
    private Pair<Integer, Integer> dimensions;
    private BirdActor actor;

    public BirdPosConverter(Pair<Integer, Integer> dimensions, BirdActor actor){
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

    public BirdPos2D getPos(BirdDirections dir){
        if(dir == BirdDirections.RIGHT){
            return getRightPos();
        }else{
            return getLeftPos();
        }
    }
}

