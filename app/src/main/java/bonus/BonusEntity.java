package bonus;

import pangGuy.gui.Shape;
import powerUp.Pickable;

/**
 * Models a Bonus with associated points
 */
public class BonusEntity extends Pickable{
    
    private final int points;

    public BonusEntity(int points, Shape shape){
        super(shape);
        this.points = points;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void activate() {
        
    }

    /**
     * Getter for points
     * @return the points associated to the Bonus
     */
    public int getPoints(){
        return this.points;
    }
}
