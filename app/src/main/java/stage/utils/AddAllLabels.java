package stage.utils;

import javax.swing.JPanel;
import stage.components.*;
/**
 * This class adds all the labels to the HUD of the stage
 */

public class AddAllLabels {
    
    /**
     * Contructor used and called only from HUDPanel
     * @param panel
     *          the HUD where to add all the labels.
     */
    public static void add(JPanel[][] panel) {
        panel[0][0].add(new PlayerOneLabel());
        panel[1][1].add(new P1ScoreLabel());
        panel[0][3].add(new StageNameLabel());
        panel[2][3].add(new StageNumberLabel());
        panel[3][3].add(new HighScoreLabel());
        panel[0][5].add(new PlayerTwoLabel());
        panel[1][6].add(new P2ScoreLabel());
    }
}
