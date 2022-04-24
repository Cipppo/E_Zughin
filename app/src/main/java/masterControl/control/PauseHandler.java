package mergeballs.control;

import java.util.List;

import mergeballs.gui.VisualInterface;
import pauseMenu.components.ExitButton;
import pauseMenu.components.PauseButton;

/**
 * This handler manage the behavior of the pause and exit buttons.
 */
public class PauseHandler {
    
    private boolean pause = false;

    public PauseHandler(VisualInterface visual, List<Pausable> pausables) {

        new PauseButton(visual, pausables, this);
        new ExitButton(visual, this);
    }

    /**
     * @return
     *          the status of the game.
     */
    public Boolean getPause() {
        return this.pause;
    }

    /**
     * Trigger the pause status ot the play status.
     */
    public void setPause() {
        this.pause = !this.pause;
    }
}
