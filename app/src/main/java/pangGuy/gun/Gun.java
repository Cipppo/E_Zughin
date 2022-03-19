package pangGuy.gun;

import pangGuy.gui.Shape;
import pangGuy.utilities.Pos2D;

import java.awt.Color;

import javax.swing.JPanel;

import pangGuy.gui.Actor;




public class Gun extends JPanel{

    private static final int WIDTH = 10;
    private static final int HEIGHT = 2;
    private static final int SPEED = 4;

    private final Actor a;
    private Shape s;
    private boolean isMovable = true;


    public Gun(Actor actor){
        this.a = actor;
        this.s = new Shape(this.a.getShape().getPos(), WIDTH, HEIGHT);


        super.setBounds(this.s.getRectangle());
        super.setBackground(Color.green);
        super.setForeground(Color.green);
        super.setOpaque(true);
        
    }

    public void changeLocation(Pos2D pos){
        if(this.isMovable){
            super.setLocation(pos.x, pos.y);
            this.s = new Shape(pos, s.getDimensions().getX(), s.getDimensions().getY());
        }
    }

    public Pos2D getPos(){
        return this.s.getPos();
    }

    public void raise(){

        Pos2D newPos = new Pos2D(this.s.getPos().x, this.s.getPos().y - SPEED);
        this.s = new Shape(newPos, this.s.getDimensions().getX(), this.s.getDimensions().getY() + SPEED);
        super.setBounds(this.s.getRectangle());
        System.out.println(this.s.getPos().toString());

    }

    public void setUnMovable(){
        this.isMovable = false;
    }

    public void setMovable(){
        this.isMovable = true;
    }

    public void restore(){
        this.s = new Shape(this.a.getShape().getPos(), WIDTH, HEIGHT);
        super.setBounds(this.s.getRectangle());
    }

    public boolean getMovable(){
        return this.isMovable;
    }

}
