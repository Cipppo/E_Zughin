package masterControl.control;

import pangGuy.character.Hero;
import player.Player;
import stage.components.HUDPanel;
import stage.utils.HUDFieldSetter;
import stage.utils.LifeSetter;
import stage.utils.P1ScoreSetter;

/**
 * This class manage the behavior of the score setter and life setter.
 */
public class HUDHandler {
    
    private final HUDFieldSetter p1ScoreSetter;
    private final HUDFieldSetter lifeSetter;

    public HUDHandler(HUDPanel hud, Player player, Hero hero){
        this.p1ScoreSetter = new P1ScoreSetter(player, hud);
        this.lifeSetter = new LifeSetter(hud, hero);
    }

    /**
     * Starts the setters.
     */
    public void startAll(){
        this.p1ScoreSetter.start();
        this.lifeSetter.start();
    }

    /**
     * Ends the setters.
     */
    public void terminator() {
        this.p1ScoreSetter.terminate();
        this.lifeSetter.terminate();
    }
}
