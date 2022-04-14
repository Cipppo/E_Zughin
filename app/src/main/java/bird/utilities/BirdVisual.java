package bird.utilities;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import bird.gui.BirdActor;
import bird.gui.BirdBoundChecker;
import bird.gui.BirdMover;
import bird.gui.BirdShape;
import pangGuy.utilities.Pair;
import stage.utils.CenterOnDefaultScreen;

/**
 * The bird visualizer with all of the bird's rules.
 * 
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
public class BirdVisual extends Thread{

    private static final int SIZEX = CenterOnDefaultScreen.center().width*70/100;
    private static final int SIZEY = CenterOnDefaultScreen.center().height*70/100;

    private static final int WIDTH = CenterOnDefaultScreen.center().width*3/100;
    private static final int HEIGHT = CenterOnDefaultScreen.center().width*3/100;;

    private static final int STARTY = 0;

    private final Random random = new Random();
    private final JPanel panel;
    private BirdShape shape;
    private BirdMover mover;
    private BirdActor actor;
    private int startX;
    private BirdDirections dir;
    private Boolean pause = false;
    private BirdMovementUtils movUtils;
    private BirdBoundChecker bc = new BirdBoundChecker(new Pair<Integer, Integer>(0, SIZEX),
                                    new Pair<Integer, Integer>(0, SIZEY));


    public BirdVisual(JPanel panel) {
        this.panel = panel;
    }
    
    /**
     * While the game isn't in pause status,
     * the bird waits for 5 to 15 seconds to appear and to start moving.
     */
    @Override
    public void run() {
        while(!this.pause) {
            
            this.dir = this.randomDirectionChooser();
            this.startX = this.dir == BirdDirections.RIGHT ? 0 : SIZEX - WIDTH;
            this.shape = new BirdShape(new BirdPos2D(startX, STARTY), WIDTH, HEIGHT, dir);
            this.actor = new BirdActor(this.shape);
            this.mover = new BirdMover(this.actor, bc);
            movUtils = new BirdMovementUtils(actor, panel, mover);

            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10) + 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            panel.add(this.actor);
            panel.repaint();
            if(startX == 0) {
                movUtils.moveRight();
            } else if(startX == SIZEX - WIDTH) {
                movUtils.moveLeft();
            }
        }
    }

    /**
     * Chooses a random direction to start the bird
     * @return
     *      the random direction
     */
    public BirdDirections randomDirectionChooser() {
        if(random.nextInt(2) == 0) {
            return BirdDirections.RIGHT;
        } else {
            return BirdDirections.LEFT;
        }
    }

    /**
     * @return
     *      the bird itself
     */
    public BirdActor getActor() {
        return this.actor;
    }

    /**
     * @return
     *      the start abscissa of this object
     */
    public int getStartX() {
        return this.startX;
    }

    /**
     * @return
     *      this bird movement utils
     */
    public BirdMovementUtils getMovementUtils() {
        return this.movUtils;
    }

    /**
     * Trigger the pause for this object
     */
    public void setPause() {
        if(this.pause) {
            this.pause = false;
            this.actor.setVisible(true);
        } else {
            this.pause = true;
            this.actor.setVisible(false);
        }
        movUtils.setPause();
    }
}
