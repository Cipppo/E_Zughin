package bird.utilities;

import javax.swing.JPanel;

import bird.actions.BirdActionFactory;
import bird.controller.BirdConstraintCheck;
import bird.gui.BirdActor;
import bird.gui.BirdBoundChecker;
import bird.gui.BirdMover;
import stage.utils.CenterOnDefaultScreen;
import pangGuy.gui.Shape;
import pangGuy.utilities.Pair;
import mergeballs.utilities.EntityPos2D;

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

    private static final int HUD_HEIGHT = CenterOnDefaultScreen.center().height*13/100;

    private final BirdActor bird;
    private final JPanel panel;
    private final BirdMover mover;
    private Boolean moveUp = false;

    private Boolean pause = false;
    private final BirdActionFactory actionFactory = new BirdActionFactory();
    private final BirdBoundChecker bc = new BirdBoundChecker(new Pair<Integer, Integer>(0, SIZEX),
                                    new Pair<Integer, Integer>(0, SIZEY));

    private final BirdConstraintCheck birdConsCheck = new BirdConstraintCheck();

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
    public BirdMovementUtils(BirdActor bird, JPanel panel, BirdMover mover) {
        this.bird = bird;
        this.panel = panel;
        this.mover = mover;
    }
    
    /**
     * Perform right movement along with vertical movement.
     */
    public final void moveRight() {
        this.moveUp = false;
        while(bird.getShape().getPos().x + WIDTH <= bc.getXPair().getY() - 5 /* && bird.getParent() == panel */) {
            this.doMovement(BirdDirections.RIGHT);
            this.moveVertically();
        }
        this.removeActor();
    }

    /**
     * Perform left movement along with vertical movement.
     */
    public final void moveLeft() {
        this.moveUp = false;
        while(bird.getShape().getPos().x >= bc.getXPair().getX() + 5 /* && bird.getParent() == panel */) {
            this.doMovement(BirdDirections.LEFT);
            this.moveVertically();
        }
        this.removeActor();
    }

    /**
     * Perform:
     *      - Down movement: if bird hasn't touched the ground yet.
     *      - Up movement: if bird has already touched ground.
     */
    public final void moveVertically() {
        if(bird.getShape().getPos().y + HEIGHT <= bc.getYPair().getY() - HUD_HEIGHT && !moveUp) {
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
                    case LEFT:
                        this.actionFactory.getLeftAction(this.mover);
                    case DOWN:
                        this.actionFactory.getDownAction(this.mover);
                    case UP:
                        this.actionFactory.getUpAction(this.mover);
                }
                if(birdConsCheck.checkEnemyCollision(new Shape(new EntityPos2D(480, 475), 20, 30), bird)) {
                    this.removeActor();
                }
                panel.repaint();
                Toolkit.getDefaultToolkit().sync();
                System.out.println(bird.getShape().getPos());
            }
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * When the bird reaches the opposite side or gets hit from an enemy, this method will remove it form the panel.
     */
    public final void removeActor() {
        /* panel.remove(this.bird); */
        panel.repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Method to pause the bird movements.
     */
    public void setPause() {
        this.pause = !this.pause;
    }
}
