package pangGuy.character;

import java.util.TimerTask;

/**
 * Handler for the hit event
 */
public class HitHandler extends TimerTask{

    private Hero hero;

    /**
     * Creates a new HitHandler
     * @param hero the Hero
     */
    public HitHandler(Hero hero){
        this.hero = hero;
    }


    @Override
    public void run() {
        try {
            this.hero.setStatus(HeroStatus.HIT);
            this.hero.hit();
            Thread.sleep(1000);
            this.hero.setStatus(HeroStatus.NEUTRAL);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep() Exception: " + e.getMessage());
        }
    }
    
}
