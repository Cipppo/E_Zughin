package bird.actions;

import bird.gui.Mover;
import bird.utilities.Directions;
import bird.utilities.Pos2D;

public class ActionFactory {

    private static final int SPEED = 5;


    private class rightAction {
        
        public rightAction(Mover m){
            m.move(new Pos2D(m.getCurrentPos().x + SPEED, m.getCurrentPos().y), Directions.RIGHT);            
        }

    }

    private class leftAction{

        public leftAction(Mover m) {
            m.move(new Pos2D(m.getCurrentPos().x - SPEED, m.getCurrentPos().y), Directions.LEFT);            
        }
    }

    public rightAction getRightAction(Mover a){
        return new rightAction(a);
    }

    public leftAction getLeftAction(Mover a){
        return new leftAction(a);
    }
    
}
