package mergeballs.control;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bonus.BonusHandler;
import mergeballs.gui.VisualTest;
import pangGuy.actions.ActionApplier;
import pangGuy.character.Hero;
import player.Player;
import powerUp.PowerUpHandler;

/**
 * Main controller of the application. It's job is to declare and
 * give to each sub controller the elements that they need.
 * The mentioned sub controllers are:
 * 
 * <ul> 
 *      <li>{@link mergeballs.control.EntityHandler}</li>
 *      <li>{@link mergeballs.control.PickableHandler}</li>
 *      <li>{@link mergeballs.control.PauseHandler}</li>
 * </ul>
 * This class instantiate also the main panel where the hero, arpions, balls, the bird and pickables
 * (bonuses and powerups) are painted (showed).
 */
public class Controller {
    private final VisualTest visual;
    private final EntityHandler entityHandler;
    private final PickableHandler pickableHandler;
    private final PauseHandler pauseHandler;
    
    public Controller(VisualTest visual, Player player, Hero hero) {
        this.visual = visual;
        
        new ActionApplier(this.visual, hero);

        this.entityHandler = new EntityHandler(this.visual, hero);
        this.pickableHandler = new PickableHandler(this.visual.getHero(), 
                        new PowerUpHandler(hero.getGset(), this.entityHandler.getBallRunner(), this.visual.getBounds()), 
                        new BonusHandler(this.visual.getBounds()), 
                        player, this.visual);

        List<Pausable> pausables = Stream.concat(this.entityHandler.getPausable().stream(), this.pickableHandler.getPausable().stream())
                                                    .collect(Collectors.toList());

        this.pauseHandler = new PauseHandler(this.visual, pausables);
    }

    public PauseHandler getPauseHandler() {
        return this.pauseHandler;
    }

    /**
     * Starts all the sub-controllers that need to be
     * active for reacting to differet events.
     */
    public void startAll() {
        this.entityHandler.start();
        this.pickableHandler.start();
    }

    /**
     * Terminate all the sub-controllers activated.
     */
    public void terminator() {
        this.entityHandler.terminate();
        this.pickableHandler.terminate();
    }
}
