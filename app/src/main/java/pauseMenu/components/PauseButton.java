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

        final KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        mainPanel.getInputMap().put(escKey, "Esc");
        mainPanel.getActionMap().put("Esc", new AbstractAction(){
        	
		private static final long serialVersionUID = -534997922777581539L;

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisibility(mainPanel, pausePanel, visual);
        }
    });
}

    public void setVisibility(JPanel mainPanel, JPanel pausePanel, BirdVisual visual) {
    	if(!pause){
            mainPanel.add(pausePanel);
            pausePanel.setVisible(true);
            visual.setPause();
            pause = true;
        } else {
            mainPanel.remove(pausePanel);
            pausePanel.setVisible(false);
            visual.setPause();
            pause = false;
        }
    }
}
