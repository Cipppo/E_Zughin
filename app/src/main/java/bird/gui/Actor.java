package bird.gui;

import javax.swing.JLabel;

import bird.utilities.Pos2D;

import java.awt.Color;

public class Actor extends JLabel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1967410748214691856L;
	private Shape s;

    public Actor(Shape s){
        this.s = s;
        
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
}
