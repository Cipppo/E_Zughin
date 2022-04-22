package mergeballs.control;

import javax.swing.JOptionPane;

import mergeballs.stage.StageGuiV2;

import pangGuy.character.Hero;

public class DeathHandler extends Thread {
    
    private Hero hero;
    private boolean stop;
    private StageGuiV2 frame; //temp, maybe wrap into a type

    public DeathHandler(StageGuiV2 frame){
        this.hero = this.frame.getHero();
        this.stop = false;
        this.frame = frame;
    }

    public DeathHandler(StageGuiV2 frame, Hero hero){
        this.hero = hero;
        this.stop = false;
        this.frame = frame;
    }

    @Override
    public void run(){
        while (!this.stop) {
            try {
                Thread.sleep(40);
                if (this.hero.getLifes() <= 0) {
                    this.frame.terminator();
                    if (this.askReplay() == 1) {
                        this.stop = true;
                        this.frame.dispose();
                        System.exit(0);
                    } else {
                        //Ultra temp, not working properly
                        // var play = this.frame.getPlayer();
                        // this.frame.dispose();
                        // this.frame = new StageGuiV2(play);
                        // this.hero = this.frame.getHero();
                    }
                }
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
