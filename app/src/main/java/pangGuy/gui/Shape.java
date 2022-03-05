package pangGuy.gui;

import java.awt.Rectangle;

import pangGuy.utilities.Pos2D;

public class Shape {

    private final Rectangle r;


    public Shape(Pos2D pos, int width, int height){
        r = new Rectangle(pos.x, pos.y, width, height);
    }
    

    public Pos2D getPos(){
        return new Pos2D((int)r.getX(), (int) r.getY());
    }

    
}
