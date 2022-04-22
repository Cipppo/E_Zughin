package mergeballs.control;

import java.util.List;

import mergeballs.gui.VisualInterface;
import pauseMenu.components.ExitButton;
import pauseMenu.components.PauseButton;

public class PauseHandler {
    
    // private final PauseButton pauseButton;
    private boolean pause = false;

    public PauseHandler(VisualInterface visual, List<Pausable> pausables) {

        new PauseButton(visual, pausables, this);
        new ExitButton(visual, this);
    }

    public Boolean getPause() {
        return this.pause;
    }

    public void setPause() {
        this.pause = !this.pause;
    }
}
