package mergeballs.control;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import endGame.EndGame;
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
                if (this.hero.getLifes() < 3) {
                    this.frame.terminator();
                    var player = this.frame.getPlayer();
                    this.frame.dispose();
                    var endgameFrame = new EndGame(player, this.frame.getHero().getLifes());
                    if (this.askReplay() == 1) {
                        this.stop = true;
                        endgameFrame.dispose();
                        System.exit(0);
                    } else {
                        player.getScore().resetScore();
                        this.frame.dispose();
                        endgameFrame.dispose();
                        this.frame = new StageGuiV2(player);
                        this.hero.reset();;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread.sleep() Exception: " + e.getMessage());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private int askReplay() {
        String options[] = {"yes", "no"};
        return JOptionPane.showOptionDialog(null, "Do you want to player again?",
                "GAME OVER",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
}
