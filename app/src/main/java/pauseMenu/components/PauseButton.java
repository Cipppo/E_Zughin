package pauseMenu.components;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import mergeballs.control.EntityHandler;
import mergeballs.control.Pausable;
import mergeballs.gui.VisualInterface;
import pangGuy.modularGun.Bullet;
import pangGuy.modularGun.GunSet;

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
    public PauseButton(VisualInterface visual, Pausable bird, Pausable hero, Pausable ballRunner, Pausable powerup, Pausable bonus, EntityHandler handler, GunSet gSet) {

        JPanel mainPanel = visual.getVisualTest();
        final KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        mainPanel.getInputMap().put(escKey, "Esc");
        mainPanel.getActionMap().put("Esc", new AbstractAction(){
        	
            private static final long serialVersionUID = -534997922777581539L;

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibility(bird, hero, ballRunner, powerup, bonus, handler, gSet);
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
    private void setVisibility(Pausable bird, Pausable hero, Pausable ballRunner, Pausable powerup, Pausable bonus, EntityHandler handler, GunSet gSet) {
    	if(!pause){
            bird.pauseAll();
            hero.pauseAll();
            ballRunner.pauseAll();
            powerup.pauseAll();
            bonus.pauseAll();
            handler.setPause();
            for(Bullet arp : gSet.getArpions()){
                arp.hit();
            }
            pause = true;
        } else {
            bird.resumeAll();
            hero.resumeAll();
            ballRunner.resumeAll();
            powerup.resumeAll();
            bonus.resumeAll();
            handler.setPause();
            pause = false;
        }
    }
}
