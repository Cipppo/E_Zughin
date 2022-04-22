package mergeballs.control;

import javax.swing.JFrame;

import pangGuy.character.Hero;

public class DeathHandler extends Thread{
    
    private final Hero hero;
    private boolean stop;
    private final JFrame frame;

    public DeathHandler(Hero hero, JFrame frame){
        this.hero = hero;
        this.stop = false;
        this.frame = frame;
    }

    @Override
    public void run(){
        while (!this.stop){
            try {
                if(this.hero.getLifes() < 0){
                    this.frame.dispose();
                }
                Thread.sleep(40);
            } catch (InterruptedException e) {
                System.out.println("Thread.sleep() Exception: " + e.getMessage());
            }
        }
    }   

}
