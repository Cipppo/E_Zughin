package masterControl.control;

import javax.swing.JOptionPane;


import endGame.EndGame;
import masterControl.stage.StageGuiV2;
import pangGuy.character.Hero;

/**
 * Controller for the Death event
 */
public class DeathHandler extends Thread {
    
    private final Hero hero;
    private boolean stop;
    private StageGuiV2 frame; //temp, maybe wrap into a type
    private EndGame endFrame;

    /**
     * Creates a new DeathHandler.
     * @param frame the game frame
     * @param hero the game Hero
     */
    public DeathHandler(StageGuiV2 frame, Hero hero){
        this.stop = false;
        this.frame = frame;
        this.hero = hero;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(){
        while (!this.stop) {
            try {
                Thread.sleep(40);
                if (this.hero.getLifes() < 0) {
                    this.frame.terminator();
                    var player = this.frame.getPlayer();
                    new EndGame(player, false, 0);
                    this.endFrame = new EndGame(player, false, 1);
                    if (this.askReplay() == 1) {
                        System.exit(0);
                    } else {
                        player.getScore().resetScore();
                        this.frame.dispose();
                        this.endFrame.dispose();
                        this.frame = new StageGuiV2(player);
                        this.hero.reset();
                        this.stop = true;
                    }
                } else {
                    if (this.frame.getController().getBallRunner().getBalls().size() == 0) {
                        this.frame.terminator();
                        var player = this.frame.getPlayer();
                        this.frame.dispose();
                        new EndGame(player, true, 0);
                        this.endFrame = new EndGame(player, true, 1);
                        Thread.sleep(4000);
                        this.endFrame.dispose();
                        this.frame = new StageGuiV2(player);
                        this.hero.reset();
                        this.stop = true;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread.sleep() Exception: " + e.getMessage());
            }
        }
    }

    /**
     * Spawns a new DialogBox which asks to the player if he wants to play again.
     * @return the Dialog response.
     */
    private int askReplay() {
        String options[] = {"yes", "no"};
        return JOptionPane.showOptionDialog(null, "Do you want to play again?",
                "GAME OVER",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
}
