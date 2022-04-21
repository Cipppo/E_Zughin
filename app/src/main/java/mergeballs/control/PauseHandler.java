package mergeballs.control;

import java.util.List;

import mergeballs.gui.VisualInterface;
import pauseMenu.components.ExitButton;
import pauseMenu.components.PauseButton;

public class PauseHandler {
    
    private final PauseButton pauseButton;

    public PauseHandler(VisualInterface visual, List<Pausable> pausables) {

        pauseButton = new PauseButton(visual, pausables);
        new ExitButton(visual, pauseButton);
    }

    public Boolean getPause() {
        return this.pauseButton.getPause();
    }
}
