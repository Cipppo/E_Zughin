package pauseMenu.components;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import masterControl.control.PauseHandler;
import masterControl.gui.VisualInterface;

/**
 * While the PauseMenu is triggered, if Enter key is pressed, the game will end.
 */

public class ExitButton{	
	
	/**
	 * Constructor that trigger the Exit action is Enter key is pressed.
	 * 
	 * @param visual
	 * 			the panel that will listen for the key to be pressed.
	 * @param pauseHandler
	 * 			the trigger for the pause.
	 */
	public ExitButton(VisualInterface visual, PauseHandler pauseHandler) {		
		JPanel mainPanel = visual.getVisualTest();
		KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        mainPanel.getInputMap().put(enterKey, "Enter");
        mainPanel.getActionMap().put("Enter", new AbstractAction(){

			private static final long serialVersionUID = -6984254615462306806L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pauseHandler.getPause()) {
					System.exit(0);	
				}
			}
        });
	}
}
