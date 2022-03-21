package pauseMenu.components;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import stage.components.MainPanel;

public class ExitButton{	
	
	public ExitButton(MainPanel mainPanel, PausePanel pausePanel) {		
		KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        mainPanel.getInputMap().put(enterKey, "Enter");
        mainPanel.getActionMap().put("Enter", new AbstractAction(){

			private static final long serialVersionUID = -6984254615462306806L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pausePanel.getVisibility()) {
					System.exit(0);	
				}
			}
        });
	}
}
