package bonus;

import java.util.Optional;

import pangGuy.gui.HeroComponent;
import pangGuy.utilities.Pair;

public class BonusHandler extends Thread{

    private static final int SPAWN_TIME = 5;
    
    private final BonusGenerator gen;
    private boolean stop;
    private boolean pause;
    Optional<BonusEntity> next;

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
                    //System.out.println("Fruit Spawned" + " X: " + this.next.get().getShape().toString());
                    Thread.sleep(SPAWN_TIME * 1000);
                } else {
                    Thread.sleep(30);
                }
            } catch(Exception e) {
                System.out.println("Thread.sleep() error: " + e.getMessage());
            }
        }
    }

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

    public synchronized void pauseAll() {
        this.pause = true;
    }

    public synchronized void resumeAll() {
        this.pause = false;
    }

    public synchronized void resetBonus(){
        this.next = Optional.empty();
    }

    public void terminate(){
        this.stop = true;
    }

}
