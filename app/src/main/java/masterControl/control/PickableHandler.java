package masterControl.control;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bonus.BonusHandler;
import masterControl.gui.VisualTest;
import pangGuy.gui.HeroComponent;
import player.Player;
import powerUp.PowerUpHandler;

/**
 * This class handles and stores all the active {@link powerUp.Pickable} in game.
 * Entities of this application are:
 * <ul> 
 *      <li>{@link powerUp.PowerUpHandler}</li>
 *      <li>{@link bonus.BonusHandler}</li>
 * </ul>
 * It's an active class, meaning that it's constantly check
 * if an item is picked up, and if it is, it activates the pickable effect.  
 */
public class PickableHandler extends Thread {
    private final HeroComponent hero;
    private final PowerUpHandler powerUp;
    private final BonusHandler bonus;
    private final Player player;
    private final VisualTest visual;
    private boolean stop;

    public PickableHandler(HeroComponent hero, PowerUpHandler powerUp, BonusHandler bonus, Player player, VisualTest visual) {
        this.stop = false;
        this.hero = hero;
        this.powerUp = powerUp;
        this.bonus = bonus;
        this.player = player;
        this.visual = visual;
    }

    @Override
    public void run() {
        this.powerUp.start();
        this.bonus.start();
        while(!this.stop) {
            try {
                this.visual.setBonuses(this.powerUp.getPowerup(), this.bonus.getBonus());

                if (!this.powerUp.getPowerup().isEmpty()) {
                    this.powerUp.checkItemTaken(this.hero);
                }

                if (!this.bonus.getBonus().isEmpty()) {
                    var score = this.bonus.getBonus().get().getPoints();
                    if (this.bonus.checkItemTaken(this.hero)) {
                        this.player.increaseScore(score);
                        System.out.println("Player score: " + this.player.getScore());
                    }
                }

                Thread.sleep(30);   
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted " + e.getMessage());
            }
        }
    }

    public synchronized List<Pausable> getPausable() {
        return Stream.of(this.bonus, this.powerUp).collect(Collectors.toList());
    }

    public synchronized void terminate() {
        this.powerUp.terminate();
        this.bonus.terminate();
        this.stop = true;
    }
}
