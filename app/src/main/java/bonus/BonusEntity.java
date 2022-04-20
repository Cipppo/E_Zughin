package bonus;

import pangGuy.gui.Shape;
import powerUp.Pickable;

public class BonusEntity extends Pickable{
    
    private final int points;

    public BonusEntity(int points, Shape shape){
        super(shape);
        this.points = points;
    }

    @Override
    public void activate() {
        // TODO Auto-generated method stub
        
    }

    public int getPoints(){
        return this.points;
    }
}
