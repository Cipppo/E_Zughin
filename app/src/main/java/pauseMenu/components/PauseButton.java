package pauseMenu.components;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import mergeballs.control.Pausable;
import mergeballs.control.PauseHandler;
import mergeballs.gui.VisualInterface;

/**
 * Pressing the Esc key, if the pause param is set to false, the PausePanel will be
 * set to visible and the objects in the main panel will be paused and viceversa.
 */
public class PauseButton {
    
    /**
     * Contructor that trigger the Pause action.
     * 
     * @param visual
     *          panel that listen for the Esc input.
     * @param pausables
     *          List of all pausables controllers to be paused.
     * @param pauseHandler
     *          the trigger for the pause.
     */
    public PauseButton(VisualInterface visual, List<Pausable> pausables, PauseHandler pauseHandler) {

        JPanel mainPanel = visual.getVisualTest();
        final KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        mainPanel.getInputMap().put(escKey, "Esc");
        mainPanel.getActionMap().put("Esc", new AbstractAction(){
        	
            private static final long serialVersionUID = -534997922777581539L;

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibility(pausables, pauseHandler);
            }
        });
    }

    /**
     * Method that trigger the pause for all the objects.
     * 
     * @param mainPanel
     *          the panel where to add the pause panel.
     * @param pausePanel
     *          the panel to be add in the main panel.
     * @param bird
     *          the bird object to be stopped.
     */
    private void setVisibility(List<Pausable> pausables, PauseHandler pauseHandler) {
    	if(!pauseHandler.getPause()){
            pausables.forEach(e -> e.pauseAll());
            pauseHandler.setPause();
        } else {
            pausables.forEach(e -> e.resumeAll());
            pauseHandler.setPause();
        }
    }
}
