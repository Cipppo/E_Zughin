package masterControl;

import masterControl.stage.StageGuiV2;
import player.Player;

public class MainStageGui {
    
	/**
	 * Test case with the HUD
	 */
    public static void main(String[] args){
        new StageGuiV2(new Player("Giacomo Poretti"));
    }
}
