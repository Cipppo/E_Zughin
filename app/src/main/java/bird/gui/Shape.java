package bird.gui;

import java.awt.Rectangle;

import bird.utilities.Pair;
import bird.utilities.Pos2D;

public class Shape {

    private final Rectangle r;


    public Shape(Pos2D pos, int width, int height){
        r = new Rectangle(pos.x, pos.y, width, height);
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

    @Override
    public String toString(){
        return "(" + this.getRectangle().toString() + ")";
    }

}