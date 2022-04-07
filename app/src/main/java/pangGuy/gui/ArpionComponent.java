package pangGuy.gui;


import pangGuy.modularGun.Status;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;
import pangGuy.utilities.PosConverter;


import java.awt.Color;

import javax.swing.JPanel;

public class ArpionComponent extends JPanel{
    
    private static final int WIDTH = 10;
    private static final int HEIGHT = 2000;
    private static final int SPEED = 5;

    private Shape s;
    private Status status;

    public ArpionComponent(Color color, Pos2D startpos){
        this.s = new Shape(startpos, WIDTH, HEIGHT);
        this.status = Status.IDLE;

        super.setBackground(color);
        super.setForeground(color);
        super.setBounds(this.s.getRectangle());
        super.setOpaque(true);

    }

    public void changeLocation(Pos2D pos){
        super.setLocation(pos.x, pos.y);
        this.s = new Shape(pos, WIDTH, HEIGHT);
    }

    public Shape getShape(){
        return this.s;
    }

    public void setDirection(Directions dir, Shape shape){
        PosConverter posConverter = new PosConverter(new Pair<Integer,Integer>(WIDTH, HEIGHT), shape);
        this.changeLocation(posConverter.getPos(dir));

    }

    public void raise(){
        this.changeLocation(new Pos2D(this.getShape().getPos().x, this.getShape().getPos().y - SPEED));
    }

    public Status getStatus(){
        return this.status;
    }

    public void setStatus(Status status){
        this.status = status;
    }
    


}
