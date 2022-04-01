package pangGuy.gui;



import java.awt.Color;

import javax.swing.JLabel;

import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;



public class Actor extends JLabel{
    
    private Shape s;

    private Directions direction;



    public Actor(Shape s){
        this.s = s;
        this.direction = Directions.LEFT;

        super.setBackground(Color.black);
        super.setBounds(this.s.getRectangle());
        super.setOpaque(true);
        
    }

    
    public void changeLocation(Pos2D pos){

        super.setLocation(pos.x, pos.y);
        this.s = new Shape(pos, this.s.getDimensions().getX(), 
        this.s.getDimensions().getY());

    
    }

    public Shape getShape(){
        return this.s;
    }

    public Directions getDir(){
        return this.direction;
    }

    public void setDir(Directions dir){
        this.direction = dir;
    }


}
