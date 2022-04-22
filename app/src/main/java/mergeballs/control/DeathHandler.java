package mergeballs.control;

import javax.swing.JOptionPane;

import mergeballs.stage.StageGuiV2;

import pangGuy.character.Hero;

public class DeathHandler extends Thread{
    
    private final Hero hero;
    private boolean stop;
    private final StageGuiV2 frame; //temp, maybe wrap into a type

    public DeathHandler(Hero hero, StageGuiV2 frame){
        this.hero = hero;
        this.stop = false;
        this.frame = frame;
    }

    @Override
    public void run(){
        while (!this.stop) {
            try {
                if (this.hero.getLifes() < 3) {
                    this.frame.terminator();
                    if (this.askReplay() == 1) {
                        this.stop = true;
                        this.frame.dispose();
                        System.exit(0);
                    }
                }
                Thread.sleep(40);
            } catch (InterruptedException e) {
                System.out.println("Thread.sleep() Exception: " + e.getMessage());
            }
        }
    }

    private int askReplay() {
        String options[] = {"yes", "no"};
        return JOptionPane.showOptionDialog(null, "Do you want to play again?",
                "GAME OVER",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
}
