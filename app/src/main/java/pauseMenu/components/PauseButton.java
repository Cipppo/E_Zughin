package pauseMenu.components;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import ball.controller.Runner;
import bird.controller.BirdHandler;
import bonus.BonusHandler;
import mergeballs.gui.VisualInterface;
import pangGuy.character.Hero;
import powerUp.PowerUpHandler;

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
    public PauseButton(VisualInterface visual, JPanel pausePanel, BirdHandler bird, Hero hero, Runner ballRunner, PowerUpHandler powerup, BonusHandler bonus) {

        JPanel mainPanel = visual.getVisualTest();
        final KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        mainPanel.getInputMap().put(escKey, "Esc");
        mainPanel.getActionMap().put("Esc", new AbstractAction(){
        	
            private static final long serialVersionUID = -534997922777581539L;

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibility(mainPanel, pausePanel, bird, hero, ballRunner, powerup, bonus);
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
    private void setVisibility(JPanel mainPanel, JPanel pausePanel, BirdHandler bird, Hero hero, Runner ballRunner, PowerUpHandler powerup, BonusHandler bonus) {
    	if(!pause){
            mainPanel.add(pausePanel);
            pausePanel.setVisible(true);
            bird.setPause();
            hero.toggleAwake();
            ballRunner.pauseAll();
            powerup.pauseAll();
            bonus.pauseAll();
            pause = true;
        } else {
            mainPanel.remove(pausePanel);
            pausePanel.setVisible(false);
            bird.setPause();
            hero.toggleAwake();
            ballRunner.resumeAll();
            powerup.resumeAll();
            bonus.resumeAll();
            pause = false;
        }
    }
}
