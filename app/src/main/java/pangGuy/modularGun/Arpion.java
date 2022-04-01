package pangGuy.modularGun;

import javax.swing.JPanel;

import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;
import pangGuy.utilities.PosConverter;
import pangGuy.utilities.Pair;
import pangGuy.gui.Shape;
import pangGuy.gui.Actor;

import java.awt.Color;

public class Arpion extends JPanel implements Bullet {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 2;
    private static final int SPEED = 4;

    private final Actor actor;
    private Shape s;
    private boolean isMovable;
    private Directions direction;

    public Arpion(Actor actor, Color color){
        super();
        this.actor = actor;
        this.s = new Shape(this.actor.getShape().getPos(), WIDTH, HEIGHT);
        this.direction = Directions.LEFT;
        this.isMovable = true;

        super.setBounds(this.s.getRectangle());
        super.setBackground(color);
        super.setOpaque(true);
    }

    private void shapeUpdater(Pos2D pos){
        this.s = new Shape(pos, s.getDimensions().getX(), s.getDimensions().getY());
    }

    @Override
    public Pos2D getPos() {
        return this.s.getPos();
    }

    @Override
    public void setPos(Pos2D pos) {
        if(this.isMovable){
            super.setLocation(pos.x, pos.y);
            this.shapeUpdater(pos);
        }
    }

    public void setUnMovable(){
        this.isMovable = false;
    }

    public void setMovable(){
        this.isMovable = true;
    }

    @Override
    public boolean isMovable() {
        return this.isMovable;
    }

    @Override
    public void restore() {
        PosConverter conv = new PosConverter(new Pair<Integer>(WIDTH, HEIGHT), this.actor);
        this.shapeUpdater(conv.getPos(this.direction));
        super.setBounds(this.s.getRectangle());
    }

    @Override
    public void raise() {
        Pos2D newPos = new Pos2D(this.s.getPos().x, this.s.getPos().y - SPEED);
        this.s = new Shape(newPos, this.s.getDimensions().getX(), this.s.getDimensions().getY() + SPEED);
        super.setBounds(this.s.getRectangle());        
    }
    
    @Override
    public void changeDir(Directions dir){
        if(this.isMovable){
            PosConverter conv = new PosConverter(new Pair<Integer>(WIDTH, HEIGHT), this.actor);
            this.setPos(conv.getPos(dir));
        }
        this.direction = dir;
    }
    
}
