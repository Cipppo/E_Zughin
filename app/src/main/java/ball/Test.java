package ball;

import ball.gui.ControlPanel;
import ball.gui.Visualiser;

public class Test {
    public static void main(String[] args) {
        Visualiser visual = new Visualiser(3);
        visual.start();
        
        ControlPanel control = new ControlPanel(visual);
        control.setVisible(true);
    }
}
