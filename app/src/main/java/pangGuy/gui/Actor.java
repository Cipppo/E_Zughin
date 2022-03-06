package pangGuy.gui;



import java.awt.Color;

import javax.swing.JLabel;

import pangGuy.utilities.Pos2D;

public class Actor extends JLabel{
    
    private Shape s;
    private final BoundChecker bChecker;


    public Actor(Shape s, BoundChecker bc){
        this.s = s;
        this.bChecker = bc;

        super.setBackground(Color.black);
        super.setBounds(this.s.getRectangle());
        super.setOpaque(true);
        

        
    }

    
    public void changeLocation(Pos2D pos){
        if(bChecker.isInside(pos, this.s.getDimensions().getX(), this.s.getDimensions().getY()));{
            super.setLocation(pos.x, pos.y);
            this.s = new Shape(pos, this.s.getDimensions().getX(), 
            this.s.getDimensions().getY());
        }
    }

    public Shape getShape(){
        return this.s;
    }

}
