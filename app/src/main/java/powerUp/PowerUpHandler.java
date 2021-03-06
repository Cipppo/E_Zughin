package powerUp;

import java.util.Optional;
import java.util.Random;

import ball.controller.BallRunner;
import masterControl.control.Pausable;
import pangGuy.gui.HeroComponent;
import pangGuy.gui.Shape;
import pangGuy.utilities.Pair;
import pangGuy.utilities.EntityPos2D;
import pangGuy.modularGun.GunBag;

/**
 * Controller for the powerups which spawns a powerup every few seconds.
 */
public class PowerUpHandler extends Thread implements Pausable {

    private static final int POWERUP_WIDTH = 24;
    private static final int POWERUP_HEIGHT = 24;
    private static final int SPAWN_TIME = 10;

    private final PowerUpGenerator gen;
    private boolean stop;
    private boolean pause;
    Optional<PowerUpEntity> next;
    private Pair<Integer, Integer> bounds;

    /**
     * Returns a new PowerUpHandler.
     * @param gSet the Hero's gunSet.
     * @param context the active BallRunner.
     * @param bounds the interface bounds.
     */
    public PowerUpHandler(GunBag gSet, BallRunner context, Pair<Integer, Integer> bounds){
        this.gen = new PowerUpGenerator(gSet, context);
        this.stop = false;
        this.pause = false;
        this.next = Optional.empty();
        this.bounds = bounds;
    }

    @Override
    public void run() {
        while(!this.stop) {
            try {
                if (!this.pause) {
                    this.next = Optional.of(new PowerUpEntity(this.gen.getRandomPowerUp(), this.generateRandomShape()));
                    System.out.println("Spawned");
                    Thread.sleep(SPAWN_TIME * 1000);
                } else {
                    Thread.sleep(30);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread.sleep() error: " + e.getMessage());
            }
        }
    }

    private synchronized EntityPos2D getRandomPos2D() {
        Random rand = new Random();
        return new EntityPos2D(rand.nextInt(this.bounds.getX()), this.bounds.getY() - 24);
    }

    @Override
    public synchronized void pauseAll() {
        this.pause = true;
    }

    @Override
    public synchronized void resumeAll() {
        this.pause = false;
    }

    private synchronized Shape generateRandomShape() {
        return new Shape(this.getRandomPos2D(), POWERUP_WIDTH, POWERUP_HEIGHT);
    }

    /**
     * Returns the generated powerup, if present.
     * @return Optional.of(Powerup) if present, Optional.empty() otherwise.
     */
    public synchronized Optional<PowerUpEntity> getPowerup() {
        if(!this.next.isEmpty()){
            var buff = this.next;
            //this.next = Optional.empty();
            return buff;
        }
        return Optional.empty();
    }    

    /**
     * Checks if the powerup is taken, if yes it activate the powerup.
     * @param hero
     */
    public synchronized void checkItemTaken(HeroComponent hero) {
        if (this.next.isPresent() && this.next.get().isPickedUp(hero)) {
            this.next.get().activate();
            this.resetPowerUp();
        }
    }

    /**
     * Resets the current Powerup.
     */
    public synchronized void resetPowerUp() {
        this.next = Optional.empty();
    }

    /**
     * Stops the Thread.
     */
    public void terminate() {
        this.stop = true;
    }
}
