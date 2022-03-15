package pauseMenu.components;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PausePanel extends JPanel {

	public PausePanel() {
        this.setBackground(new Color(0,0,0,220));
        this.add(new JLabel("PROOVA"));
        this.setVisible(false);
    }
    
}
