package bonus;

import java.util.Optional;

import masterControl.control.Pausable;
import pangGuy.gui.HeroComponent;
import pangGuy.utilities.Pair;

/**
 * Controller which manages the Bonus Spawn
 */
public class BonusHandler extends Thread implements Pausable {

    private static final int SPAWN_TIME = 5;
    
    private final BonusGenerator gen;
    private boolean stop;
    private boolean pause;
    Optional<BonusEntity> next;

    /**
     * Creates a new BonusHandler 
     * @param bounds the window XMAX, YMAX
     */
    public BonusHandler(Pair<Integer, Integer> bounds) {
        this.gen = new BonusGenerator(bounds);
        this.next = Optional.empty();
        this.pause = 
        this.stop = false;
    }

    @Override
    public void run(){
        while(!this.stop){
            try {
                if (!this.pause) {
                    this.next = Optional.of(gen.generateNextBonus());
                    Thread.sleep(SPAWN_TIME * 1000);
                } else {
                    Thread.sleep(30);
                }
            } catch(Exception e) {
                System.out.println("Thread.sleep() error: " + e.getMessage());
            }
        }
    }

    /**
     * Returns the actual bonus, if available
     * @return Optional.of(BonusEntity) if available, Optional.empty otherwise.
     */
    public synchronized Optional<BonusEntity> getBonus(){
        if(!this.next.isEmpty()){
            return this.next;
        }
        return Optional.empty();
    }

    public synchronized boolean checkItemTaken(HeroComponent hero){
        if (this.next.isPresent() && this.next.get().isPickedUp(hero)) {
            this.resetBonus();
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void pauseAll() {
        this.pause = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void resumeAll() {
        this.pause = false;
    }

    /**
     * Resets the actual Bonus making it disappear.
     */
    public synchronized void resetBonus(){
        this.next = Optional.empty();
    }

    /**
     * Terminates the Thread.
     */
    public void terminate(){
        this.stop = true;
    }

}
