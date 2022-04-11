package bird.actions;

import bird.gui.BirdMover;
import bird.utilities.BirdDirections;
import bird.utilities.BirdPos2D;

public class BirdActionFactory {

    private static final int SPEED = 5;


    private class rightAction {
        
        public rightAction(BirdMover m){
            m.move(new BirdPos2D(m.getCurrentPos().x + SPEED, m.getCurrentPos().y), BirdDirections.RIGHT);            
        }

    }

    private class leftAction{

        public leftAction(BirdMover m) {
            m.move(new BirdPos2D(m.getCurrentPos().x - SPEED, m.getCurrentPos().y), BirdDirections.LEFT);            
        }
    }

    private class downAction{

        public downAction(BirdMover m) {
            m.move(new BirdPos2D(m.getCurrentPos().x, m.getCurrentPos().y + SPEED), BirdDirections.DOWN);
        }
    }

    private class upAction{

        public upAction(BirdMover m) {
            m.move(new BirdPos2D(m.getCurrentPos().x, m.getCurrentPos().y - SPEED), BirdDirections.UP);
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
