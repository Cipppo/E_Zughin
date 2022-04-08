package bird.actions;

import bird.gui.Mover;
import bird.utilities.Directions;
import bird.utilities.BirdPos2D;

public class ActionFactory {

    private static final int SPEED = 5;


    private class rightAction {
        
        public rightAction(Mover m){
            m.move(new BirdPos2D(m.getCurrentPos().x + SPEED, m.getCurrentPos().y), Directions.RIGHT);            
        }

    }

    private class leftAction{

        public leftAction(Mover m) {
            m.move(new BirdPos2D(m.getCurrentPos().x - SPEED, m.getCurrentPos().y), Directions.LEFT);            
        }
    }

    private class downAction{

        public downAction(Mover m) {
            m.move(new BirdPos2D(m.getCurrentPos().x, m.getCurrentPos().y + SPEED), Directions.DOWN);
        }
    }

    private class upAction{

        public upAction(Mover m) {
            m.move(new BirdPos2D(m.getCurrentPos().x, m.getCurrentPos().y - SPEED), Directions.UP);
        }
    }

    public rightAction getRightAction(Mover a){
        return new rightAction(a);
    }

    public leftAction getLeftAction(Mover a){
        return new leftAction(a);
    }

    public downAction getDownAction(Mover a) {
        return new downAction(a);
    }

    public upAction getUpAction(Mover a) {
        return new upAction(a);
    }
    
}
