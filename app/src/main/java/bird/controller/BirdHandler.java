package bird.controller;

import java.util.Optional;
import java.util.Random;

import bird.gui.BirdActor;
import bird.gui.BirdBoundChecker;
import bird.gui.BirdMover;
import bird.utilities.BirdDirections;
import bird.utilities.BirdMovementUtils;
import fruit.Shape;
import mergeballs.utilities.EntityShape;
import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;
import stage.utils.CenterOnDefaultScreen;

public class BirdHandler extends Thread{
    
    private static final int SIZEX = CenterOnDefaultScreen.center().width*70/100;
    private static final int SIZEY = CenterOnDefaultScreen.center().height*70/100;

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
    
    @Override
    public void run() {
        while(!this.birdDead) {
            while(!this.pause) {
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
            }
            try {
                Thread.sleep(getTimeToSleep()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private final synchronized void createBird() {
        this.startPosX = this.dir == BirdDirections.RIGHT ? 0 : SIZEX - WIDTH;
        this.actor = Optional.of(new BirdActor(new EntityPos2D(this.startPosX, STARTY)));
        this.mover = new BirdMover(this.actor.get(), this.bc);
        this.movUtils = new BirdMovementUtils(this.actor.get(), this.mover);
    }

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

    public Optional<EntityShape> getShape() {
        if(!this.actor.isEmpty()) {
            return Optional.of(this.actor.get().getShape());
        } else {
            return Optional.empty();
        }
        
    }

    public void removeBird() {
        this.birdDead = true;
    }

    /**
     * Trigger the pause for this object
     */
    public void setPause() {
        if(this.pause) {
            this.pause = false;
            /* this.actor.setVisible(true); */
        } else {
            this.pause = true;
            /* this.actor.setVisible(false); */
        }
        movUtils.setPause();
    }

    public void setBirdDead() {
        this.movUtils.setDead();
    }
}
