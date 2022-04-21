package mergeballs.control;

import java.util.List;

import bonus.BonusHandler;
import bonus.Score;
import pangGuy.character.Hero;
import pangGuy.gui.HeroComponent;
import player.Player;
import powerUp.PowerUpHandler;

public class PickableHandler extends Thread {
    private final HeroComponent hero;
    private final PowerUpHandler powerUp;
    private final BonusHandler bonus;
    private final Player player;
    private boolean stop;
    private final Score score; //temp

    public PickableHandler(HeroComponent hero, PowerUpHandler powerUp, BonusHandler bonus, Player player, Score score) {
        this.stop = false;
        this.hero = hero;
        this.powerUp = powerUp;
        this.bonus = bonus;
        this.player = player;
        this.score = score;
    }

    @Override
    public void run() {
        this.powerUp.start();
        this.bonus.start();
        while(!this.stop) {
            try {
                
                if (!this.powerUp.getPowerup().isEmpty()) {
                    this.powerUp.checkItemTaken(this.hero);
                }

                if (!this.bonus.getBonus().isEmpty()) {
                    if (this.bonus.checkItemTaken(this.hero)) {
                        this.score.raiseScore(this.bonus.getBonus().get().getPoints());
                    }
                }

                Thread.sleep(30);   
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted " + e.getMessage());
            }
        }
    }

    public synchronized List<Pausable> getPausable() {
        return List.of(this.bonus, this.powerUp);
    }

}
