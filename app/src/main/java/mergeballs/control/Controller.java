package mergeballs.control;

import java.util.ArrayList;
import java.util.List;

import bonus.BonusHandler;
import mergeballs.gui.VisualTest;
import pangGuy.actions.ActionApplier;
import pangGuy.character.Hero;
import player.Player;
import powerUp.PowerUpHandler;

public class Controller {
    private final VisualTest visual;
    private final EntityHandler entityHandler;
    private final PickableHandler pickableHandler;
    private final PauseHandler pauseHandler;
    
    public Controller(VisualTest visual, Player player) {
        this.visual = visual;
        
        Hero hero = new Hero();
        new ActionApplier(this.visual, hero);

        this.entityHandler = new EntityHandler(this.visual, hero);
        this.pickableHandler = new PickableHandler(this.visual.getHero(), 
                        new PowerUpHandler(hero.getGset(), this.entityHandler.getBallRunner(), this.visual.getBounds()), 
                        new BonusHandler(this.visual.getBounds()), 
                        player, this.visual);

        List<Pausable> pausables = new ArrayList<>();
        for (final var elem : this.entityHandler.getPausable()) {
            pausables.add(elem);
        }
        for (final var elem : this.pickableHandler.getPausable()) {
            pausables.add(elem);
        }

        this.pauseHandler = new PauseHandler(this.visual, pausables);
    }

    public PauseHandler getPauseHandler() {
        return this.pauseHandler;
    }

    public void startAll() {
        this.entityHandler.start();
        this.pickableHandler.start();
    }
}
