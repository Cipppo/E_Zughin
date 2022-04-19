package bird.utilities;

import bird.actions.BirdActionFactory;
import bird.gui.BirdActor;
import bird.gui.BirdBoundChecker;
import bird.gui.BirdMover;
import stage.utils.CenterOnDefaultScreen;
import pangGuy.utilities.Pair;

import java.awt.Toolkit;

/**
 * Utility that choose the bird's moovements considering its position.
 * @param SIZEX
 *          width of the stage
 * @param SIZEY
 *          height of the stage
 * @param WIDTH
 *          width of the bird
 * @param HEIGHT
 *          height of the bird
 * @param HUD_HEIGHT
 *          height of the HUD, defining the ground level
 */
public class BirdMovementUtils {

    private static final int SIZEX = CenterOnDefaultScreen.center().width*70/100;
    private static final int SIZEY = CenterOnDefaultScreen.center().height*70/100;

    private static final int WIDTH = CenterOnDefaultScreen.center().width*3/100;
    private static final int HEIGHT = CenterOnDefaultScreen.center().width*3/100;;

    // private static final int HUD_HEIGHT = CenterOnDefaultScreen.center().height*13/100;

    private final BirdActor bird;
    private final BirdMover mover;
    private Boolean moveUp = false;

    private Boolean pause = false;
    private Boolean birdDead = false;
    private final BirdActionFactory actionFactory = new BirdActionFactory();
    private final BirdBoundChecker bc = new BirdBoundChecker(new Pair<Integer, Integer>(0, SIZEX),
                                    new Pair<Integer, Integer>(0, SIZEY));

    /**
     * Cuntructor that define the bird to move, the panel on which to move the bird
     * and the mover utility.
     * 
     * @param bird
     *          the bird to move.
     * @param panel
     *          the panel to repaint.
     * @param mover
     *          the mover utility.
     */                                
    public BirdMovementUtils(BirdActor bird, BirdMover mover) {
        this.bird = bird;
        this.mover = mover;
    }
    
    /**
     * Perform right movement along with vertical movement.
     */
    public final void moveRight() {
        this.moveUp = false;
        while(bird.getShape().getPos().getX() + WIDTH <= bc.getXPair().getY() - 5 && this.birdDead != true) {
            this.doMovement(BirdDirections.RIGHT);
            this.moveVertically();
        }
    }

    /**
     * Perform left movement along with vertical movement.
     */
    public final void moveLeft() {
        this.moveUp = false;
        while(bird.getShape().getPos().getX() >= bc.getXPair().getX() + 5 && this.birdDead != true) {
            this.doMovement(BirdDirections.LEFT);
            this.moveVertically();
        }
    }

    /**
     * Perform:
     *      - Down movement: if bird hasn't touched the ground yet.
     *      - Up movement: if bird has already touched ground.
     */
    public final void moveVertically() {
        if(bird.getShape().getPos().getY() + HEIGHT <= bc.getYPair().getY() && !moveUp) {
            this.doMovement(BirdDirections.DOWN);
        } else {
            this.moveUp = true;
            this.doMovement(BirdDirections.UP);
        }
    }

    /**
     * Given a direction, this method will call the appropriate movement method
     * from the mover class.
     * 
     * @param dir
     *          the choosen direction.
     */
    private final void doMovement(BirdDirections dir) {
        try {
            if(!this.pause) {
                switch(dir) {
                    case RIGHT:
                        this.actionFactory.getRightAction(this.mover);
                        break;
                    case LEFT:
                        this.actionFactory.getLeftAction(this.mover);
                        break;
                    case DOWN:
                        this.actionFactory.getDownAction(this.mover);
                        break;
                    case UP:
                        this.actionFactory.getUpAction(this.mover);
                        break;
                }
                /* panel.repaint(); */
                Toolkit.getDefaultToolkit().sync();
                // System.out.println(bird.getShape().getPos());
            }
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to pause the bird movements.
     */
    public void setPause() {
        this.pause = !this.pause;
    }

    public void setDead() {
        this.birdDead = true;
    }
}
