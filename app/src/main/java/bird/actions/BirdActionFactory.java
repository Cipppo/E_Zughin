package bird.actions;

import bird.gui.BirdMover;
import bird.utilities.BirdDirections;
import pangGuy.utilities.EntityPos2D;

public class BirdActionFactory {

    private static final int SPEED = 5;


    private class rightAction {
        
        public rightAction(BirdMover m){
            m.move(new EntityPos2D(m.getCurrentPos().getX() + SPEED, m.getCurrentPos().getY()), BirdDirections.RIGHT);            
        }

    }

    private class leftAction{

        public leftAction(BirdMover m) {
            m.move(new EntityPos2D(m.getCurrentPos().getX() - SPEED, m.getCurrentPos().getY()), BirdDirections.LEFT);            
        }
    }

    private class downAction{

        public downAction(BirdMover m) {
            m.move(new EntityPos2D(m.getCurrentPos().getX(), m.getCurrentPos().getY() + SPEED), BirdDirections.DOWN);
        }
    }

    private class upAction{

        public upAction(BirdMover m) {
            m.move(new EntityPos2D(m.getCurrentPos().getX(), m.getCurrentPos().getY() - SPEED), BirdDirections.UP);
        }
    }

    public rightAction getRightAction(BirdMover a){
        return new rightAction(a);
    }

    public leftAction getLeftAction(BirdMover a){
        return new leftAction(a);
    }

    public downAction getDownAction(BirdMover a) {
        return new downAction(a);
    }

    public upAction getUpAction(BirdMover a) {
        return new upAction(a);
    }
    
}
