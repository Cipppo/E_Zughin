package pangGuy.character;

import java.util.TimerTask;

public class HitHandler extends TimerTask{

    private Hero hero;

    public HitHandler(Hero hero){
        this.hero = hero;
    }


    @Override
    public void run() {
        try {
            this.hero.setStatus(heroStatus.HIT);
            this.hero.hit();
            Thread.sleep(1000);
            this.hero.setStatus(heroStatus.NEUTRAL);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep() Exception: " + e.getMessage());
        }
    }
    
}
