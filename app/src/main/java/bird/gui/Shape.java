package bird.gui;

import java.awt.Rectangle;
import java.util.Optional;

import bird.utilities.Directions;
import bird.utilities.Pair;
import bird.utilities.Pos2D;

public class Shape {

    private final Rectangle r;
    private final Optional<Directions> dir;


    public Shape(Pos2D pos, int width, int height, Optional<Directions> dir){
        r = new Rectangle(pos.x, pos.y, width, height);
        if(!dir.isEmpty()) {
            this.dir = dir;
        } else {
            this.dir = Optional.empty();
        }
    }
    

    public Pos2D getPos(){
        return new Pos2D((int)r.getX(), (int) r.getY());
    }


    public Pair<Integer> getDimensions(){
        return new Pair<Integer>((int)r.getWidth(), (int)r.getHeight());
    }
    
    public Rectangle getRectangle(){
        return this.r;
    }

    public Directions getDireciton() {
        return this.dir.get();
    }

    @Override
    public String toString(){
        return "(" + this.getRectangle().toString() + ")";
    }

}