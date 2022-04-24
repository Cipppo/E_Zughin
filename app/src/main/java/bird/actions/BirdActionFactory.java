package bird.actions;

import bird.gui.BirdMover;
import bird.utilities.BirdDirections;
import pangGuy.utilities.EntityPos2D;

/**
 * A factory which models the main character Actions.
 */
public class BirdActionFactory {

    private static final int SPEED = 5;

    /**
     * The action which permits the bird to move Right.
     */
    private class RightAction {
        
        public RightAction(BirdMover m){
            m.move(new EntityPos2D(m.getCurrentPos().getX() + SPEED, m.getCurrentPos().getY()), BirdDirections.RIGHT);            
        }

    }

    /**
     * The action which permits the bird to move Left.
     */
    private class LeftAction{

        public LeftAction(BirdMover m) {
            m.move(new EntityPos2D(m.getCurrentPos().getX() - SPEED, m.getCurrentPos().getY()), BirdDirections.LEFT);            
        }
    }

    /**
     * The action which permits the bird to move Down.
     */
    private class DownAction{

        public DownAction(BirdMover m) {
            m.move(new EntityPos2D(m.getCurrentPos().getX(), m.getCurrentPos().getY() + SPEED), BirdDirections.DOWN);
        }
    }

    /**
     * The action which permits the bird to move Up.
     */
    private class UpAction{

        public UpAction(BirdMover m) {
            m.move(new EntityPos2D(m.getCurrentPos().getX(), m.getCurrentPos().getY() - SPEED), BirdDirections.UP);
        }
    }

    public RightAction getRightAction(BirdMover m){
        return new RightAction(m);
    }

    public LeftAction getLeftAction(BirdMover m){
        return new LeftAction(m);
    }

    public DownAction getDownAction(BirdMover m) {
        return new DownAction(m);
    }

    public UpAction getUpAction(BirdMover m) {
        return new UpAction(m);
    }
    
}
