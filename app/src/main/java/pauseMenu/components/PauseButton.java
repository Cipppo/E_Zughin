package pauseMenu.components;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import mergeballs.control.Pausable;
import mergeballs.gui.VisualInterface;

/**
 * Pressing the Esc key, if the pause param is set to false, the PausePanel will be
 * set to visible and the objects in the main panel will be paused and viceversa.
 * 
 * @param pause
 *          variable to check if the games is in pause status or not.
 */
public class PauseButton {

    private boolean pause = false;
    
    /**
     * Contructor that trigger the Pause action.
     * 
     * @param visual
     *          panel that listen for the Esc input.
     * @param pausePanel
     *          the pause panel.
     * @param bird
     *          the bird object.
     */
    public PauseButton(VisualInterface visual, List<Pausable> pausables) {

        JPanel mainPanel = visual.getVisualTest();
        final KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        mainPanel.getInputMap().put(escKey, "Esc");
        mainPanel.getActionMap().put("Esc", new AbstractAction(){
        	
            private static final long serialVersionUID = -534997922777581539L;

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibility(pausables);
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
    private void setVisibility(List<Pausable> pausables) {
    	if(!pause){
            pausables.forEach(e -> e.pauseAll());
            this.pause = true;
        } else {
            pausables.forEach(e -> e.resumeAll());
            this.pause = false;
        }
    }
}
