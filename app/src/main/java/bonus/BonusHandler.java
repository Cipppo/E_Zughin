package bonus;

import java.util.Optional;

import pangGuy.gui.HeroComponent;
import pangGuy.utilities.Pair;

public class BonusHandler extends Thread{

    private static final int SPAWN_TIME = 5;
    
    private final BonusGenerator gen;
    private boolean stop;
    Optional<BonusEntity> next;

    public BonusHandler(Pair<Integer, Integer> bounds){
        this.gen = new BonusGenerator(bounds);
        this.next = Optional.empty();
        this.stop = false;
    }

    @Override
    public void run(){
        while(!stop){
            try{
                this.next = Optional.of(gen.generateNextBonus());
                System.out.println("Fruit Spawned");
                Thread.sleep(SPAWN_TIME * 1000);
            }catch(Exception e){
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

    public synchronized void checkItemTaken(HeroComponent hero){
        if (this.next.isPresent() && this.next.get().isPickedUp(hero)) {
            this.resetBonus();
        }
    }

    public synchronized void resetBonus(){
        this.next = Optional.empty();
    }

    public void terminate(){
        this.stop = true;
    }

}
