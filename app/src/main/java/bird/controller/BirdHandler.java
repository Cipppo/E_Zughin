package bird.controller;

import java.util.Optional;
import java.util.Random;

import bird.gui.BirdActor;
import bird.gui.BirdBoundChecker;
import bird.gui.BirdMover;
import bird.gui.BirdShape;
import bird.utilities.BirdDirections;
import bird.utilities.BirdMovementUtils;
import masterControl.control.Pausable;
import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;
import stage.utils.CenterOnDefaultScreen;

/**
 * The handler of the bird.
 * This class manage the bird spawning and movement.
 */
public class BirdHandler extends Thread implements Pausable {
    
    private static final int SIZEX = CenterOnDefaultScreen.center().width*70/100;
    private static final int SIZEY = CenterOnDefaultScreen.center().height*60/100;

    private static final int WIDTH = CenterOnDefaultScreen.center().width*3/100;

    private static final int STARTY = 0;

    
    private final Random random = new Random();
    private BirdMover mover;
    private Optional<BirdActor> actor;
    private int startPosX;
    private BirdDirections dir;
    private Boolean pause = false;
    private boolean birdDead = false;
    private BirdMovementUtils movUtils;
    private BirdBoundChecker bc = new BirdBoundChecker(new Pair<Integer, Integer>(0, SIZEX),
                                    new Pair<Integer, Integer>(0, SIZEY));
    private Boolean terminated = false;
    
    /**
     * This thread make the bird move while it's not dead
     */
    @Override
    public void run() {
        while(!this.terminated) {
            while (!this.birdDead) {
                while (!this.pause) {
                    try {
                        this.createBird();
                        Thread.sleep(20);
                        if(this.startPosX == 0) {
                            movUtils.moveRight();
                        } else if(this.startPosX == SIZEX - WIDTH) {
                            movUtils.moveLeft();
                        }
                        this.actor = Optional.empty();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(getTimeToSleep()*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * This method create the bird.
     */
    private final synchronized void createBird() {
        this.dir = this.randomDirectionChooser();
        this.startPosX = this.dir == BirdDirections.RIGHT ? 0 : SIZEX - WIDTH;
        this.actor = Optional.of(new BirdActor(new EntityPos2D(this.startPosX, STARTY), this.dir));
        this.mover = new BirdMover(this.actor.get(), this.bc);
        this.movUtils = new BirdMovementUtils(this.actor.get(), this.mover);
    }

    /**
     * Timeout between the spawn of a bird after the dead of the previous one.
     * @return
     *          the time to wait.
     */
    private final int getTimeToSleep() {
        return random.nextInt(10) + 5;
    }

    /**
     * @return
     *      the bird itself
     */
    public Optional<BirdActor> getActor() {
        return this.actor;
    }

    /**
     * @return
     *          the shape if the bird exists, Optional.empty() otherwise.
     */
    public Optional<BirdShape> getShape() {
        if (!this.actor.isEmpty()) {
            return Optional.of(this.actor.get().getShape());
        } else {
            return Optional.empty();
        }
        
    }

    /**
     * When a bird gets hit or reaches the end of the stage, it is set to dead.
     */
    public void setBirdDead() {
        this.birdDead = true;
        this.movUtils.setDead();
    }

    /**
     * @return
     *          a random direction for the bird.
     */
    private final BirdDirections randomDirectionChooser() {
        if(random.nextInt(2) == 0) {
            return BirdDirections.RIGHT;
        } else {
            return BirdDirections.LEFT;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pauseAll() {
        this.pause = true;
        movUtils.setPause();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resumeAll() {
        this.pause = false;
        movUtils.setPause();        
    }

    public synchronized void terminate() {
        this.setBirdDead();
        this.terminated = true;
    }
}
