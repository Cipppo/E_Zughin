package mergeballs.control;

import java.util.List;

import mergeballs.gui.VisualInterface;
import pauseMenu.components.ExitButton;
import pauseMenu.components.PauseButton;

public class PauseHandler {
    
    public PauseHandler(VisualInterface visual, List<Pausable> pausables) {

        new PauseButton(visual, pausables);
        new ExitButton(visual);
    }
}
