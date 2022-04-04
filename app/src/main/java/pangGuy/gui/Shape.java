package pangGuy.gui;

import java.awt.Rectangle;

import pangGuy.utilities.Pos2D;
import pangGuy.utilities.Pair;

public class Shape {

    private final Rectangle r;


    public Shape(Pos2D pos, int width, int height){
        r = new Rectangle(pos.x, pos.y, width, height);
    }
    

    public Pos2D getPos(){
        return new Pos2D((int)r.getX(), (int) r.getY());
    }


    public Pair<Integer, Integer> getDimensions(){
        return new Pair<Integer, Integer>((int)r.getWidth(), (int)r.getHeight());
    }
    
    public Rectangle getRectangle(){
        return this.r;
    }

    public Pos2D getLeftFoot(){
        Pos2D mainPos = this.getPos();
        return new Pos2D(mainPos.x, mainPos.y + (int) this.r.getHeight());
    }

    @Override
    public String toString(){
        return "(" + this.getRectangle().toString() + ")";
    }

}
