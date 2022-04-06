package pauseMenu.components;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import bird.utilities.MoveBird;
import stage.components.TimerLabel;

public class PauseButton {

    private boolean pause = false;
    
    public PauseButton(JPanel mainPanel, JPanel pausePanel, TimerLabel timer, MoveBird moveBird) {

        KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        mainPanel.getInputMap().put(escKey, "Esc");
        mainPanel.getActionMap().put("Esc", new AbstractAction(){
        	
		private static final long serialVersionUID = -534997922777581539L;

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisibility(pausePanel, timer, moveBird);
        }
    });
    }

    public void setVisibility(JPanel pausePanel, TimerLabel timer, MoveBird moveBird) {
    	if(!pause){
            pausePanel.setVisible(true);
            timer.getTimer().stop();
            moveBird.setPause();
            pause = true;
        } else {
            pausePanel.setVisible(false);
            timer.getTimer().start();
            moveBird.setPause();
            pause = false;
        }
    }
}
