package pangGuy.gun;

import pangGuy.gui.Shape;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;
import pangGuy.utilities.PosConverter;
import pangGuy.utilities.Pair;
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
    private Directions direction;

    public Gun(Actor actor, Color color){
        this.a = actor;
        this.s = new Shape(this.a.getShape().getPos(), WIDTH, HEIGHT);
        this.direction = Directions.LEFT;


        super.setBounds(this.s.getRectangle());
        super.setBackground(color);
        super.setForeground(color);
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
        //System.out.println(this.s.getPos().toString());

    }

    public void changeDir(Directions dir){
        if(this.isMovable){
            PosConverter conv = new PosConverter(new Pair<Integer, Integer> (WIDTH, HEIGHT), this.a);
            
            this.s = new Shape(conv.getPos(dir), WIDTH, HEIGHT);
            super.setLocation(conv.getPos(dir).x, conv.getPos(dir).y);
            
        }
        this.direction = dir;
    }

    public void setUnMovable(){
        this.isMovable = false;
    }

    public void setMovable(){
        this.isMovable = true;
    }

    public void restore(){
        PosConverter conv = new PosConverter(new Pair<Integer, Integer> (WIDTH, HEIGHT), this.a);
        this.s = new Shape(conv.getPos(this.direction), WIDTH, HEIGHT);
        super.setBounds(this.s.getRectangle());
    }

    public boolean getMovable(){
        return this.isMovable;
    }



}
