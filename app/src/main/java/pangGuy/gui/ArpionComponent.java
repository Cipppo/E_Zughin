package pangGuy.gui;


import pangGuy.modularGun.GunTypes;
import pangGuy.modularGun.Status;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pair;
import pangGuy.utilities.PosConverter;
import pangGuy.utilities.EntityPos2D;

/**
 * Models a GUI component for the arpion class.
 */

public class ArpionComponent{
    
    private static final int WIDTH = 10;
    private static final int HEIGHT = 2000;
    private static final int SPEED = 5;

    private Shape s;
    private Status status;
    private Directions dir;
    private GunTypes type;

    /**
     * Creates a new ArpionComponent with default values
     * @param startpos the position where the component has to be set in the GUI at the start.
     */
    public ArpionComponent(EntityPos2D startpos){
        this.s = new Shape(startpos, WIDTH, HEIGHT);
        this.status = Status.IDLE;
        this.dir = Directions.LEFT;
        this.type = GunTypes.ARPION;
    }

    /**
     * Setter for the Position.
     * @param pos the next component position.
     */
    public void changeLocation(EntityPos2D pos){
        this.s = new Shape(pos, WIDTH, HEIGHT);
    }

    /**
     * Getter for the Shape.
     * @return the the actual Shape.
     */
    public Shape getShape(){
        return this.s;
    }

    /**
     * Changes the position based on the direction. 
     * @param dir the next direction.
     * @param shape the Hero Shape.
     */
    public void setDirection(Directions dir, Shape shape){
        PosConverter posConverter = new PosConverter(new Pair<Integer,Integer>(WIDTH, HEIGHT), shape);
        this.changeLocation(posConverter.getPos(dir));
        this.dir = dir;
    }

    /**
     * Raises the component by one step.
     */
    public void raise(){
        this.changeLocation(new EntityPos2D(this.getShape().getPos().getX(), this.getShape().getPos().getY() - SPEED));
    }

    /**
     * Getter for the status.
     */
    public Status getStatus(){
        return this.status;
    }

    /**
     * Setter for the Status.
     * @param status the status that needs to be set.
     */
    public void setStatus(Status status){
        this.status = status;
    }

    /**
     * Getter for the Direction.
     * @return the actual Direction.
     */
    public Directions getDirection(){
        return this.dir;
    }
    
    /**
     * Setter for the GunType.
     * @param type the GunType that needs to be set.
     */
    public void setType(GunTypes type){
        this.type = type;
    }

    /**
     * Getter for the GunType.
     * @return the actual GunType.
     */
    public GunTypes gType(){
        return this.type;
    }

}
