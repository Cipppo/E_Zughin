package pangGuy.gun;

import pangGuy.gui.Shape;
import pangGuy.utilities.Pos2D;

import java.awt.Color;

import javax.swing.JPanel;

import pangGuy.gui.Actor;

public class Gun extends JPanel{

    private final Actor a;

    public Gun(Actor actor){
        this.a = actor;

        super.setBounds(new Shape(this.a.getShape().getPos(), 10, 2).getRectangle());
        super.setBackground(Color.green);
        super.setForeground(Color.green);
        super.setOpaque(true);
        
    }

    public void changeLocation(Pos2D pos){
        super.setLocation(pos.x, pos.y);
    }



}
