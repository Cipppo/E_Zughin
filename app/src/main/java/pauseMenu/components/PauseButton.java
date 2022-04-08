package pauseMenu.components;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import bird.utilities.BirdVisual;

public class PauseButton {

    private boolean pause = false;
    
    public PauseButton(JPanel mainPanel, JPanel pausePanel, BirdVisual visual) {

        KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        mainPanel.getInputMap().put(escKey, "Esc");
        mainPanel.getActionMap().put("Esc", new AbstractAction(){
        	
		private static final long serialVersionUID = -534997922777581539L;

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisibility(pausePanel, visual);
        }
    });
    }

    public void setVisibility(JPanel pausePanel, BirdVisual visual) {
    	if(!pause){
            pausePanel.setVisible(true);
            visual.setPause();
            pause = true;
        } else {
            pausePanel.setVisible(false);
            visual.setPause();
            pause = false;
        }
    }
}
