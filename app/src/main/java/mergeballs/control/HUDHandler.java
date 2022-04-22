package mergeballs.control;

import pangGuy.character.Hero;
import player.Player;
import stage.components.HUDPanel;
import stage.utils.LifeSetter;
import stage.utils.P1ScoreSetter;

public class HUDHandler {
    
    private final P1ScoreSetter p1ScoreSetter;
    private final LifeSetter lifeSetter;

    public HUDHandler(HUDPanel hud, Player player, Hero hero){
        this.p1ScoreSetter = new P1ScoreSetter(player, hud);
        this.lifeSetter = new LifeSetter(hud, hero);
    }

    public void startAll(){
        this.p1ScoreSetter.start();
        this.lifeSetter.start();
    }

}
