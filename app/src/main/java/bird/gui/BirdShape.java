package bird.gui;

import java.awt.Rectangle;
import java.util.Optional;

import bird.utilities.BirdDirections;
import pangGuy.utilities.Pair;
import bird.utilities.BirdPos2D;

public class BirdShape {

    private final Rectangle r;
    private final Optional<BirdDirections> dir;


    public BirdShape(BirdPos2D pos, int width, int height, Optional<BirdDirections> dir){
        r = new Rectangle(pos.x, pos.y, width, height);
        if(!dir.isEmpty()) {
            this.dir = dir;
        } else {
            this.dir = Optional.empty();
        }
    }
    

    public BirdPos2D getPos(){
        return new BirdPos2D((int)r.getX(), (int) r.getY());
    }


    public Pair<Integer, Integer> getDimensions(){
        return new Pair<Integer, Integer>((int)r.getWidth(), (int)r.getHeight());
    }
    
    public Rectangle getRectangle(){
        return this.r;
    }

    public BirdDirections getDireciton() {
        return this.dir.get();
    }

    @Override
    public String toString(){
        return "(" + this.getRectangle().toString() + ")";
    }

}