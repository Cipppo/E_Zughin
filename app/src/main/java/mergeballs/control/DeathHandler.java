package mergeballs.control;

import pangGuy.character.Hero;

public class DeathHandler extends Thread{
    
    private final Hero hero;
    private boolean stop;

    public DeathHandler(Hero hero){
        this.hero = hero;
        this.stop = false;
    }

    @Override
    public void run(){
        while (!this.stop){
            try {
                if(this.hero.getLifes() < 0){
                    System.exit(0);
                }
                Thread.sleep(40);
            } catch (InterruptedException e) {
                System.out.println("Thread.sleep() Exception: " + e.getMessage());
            }
        }
    }   

}
