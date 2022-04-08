package ball.controller;

import ball.gui.Visual;

public class InterTest {
    public static void main(String[] args) {
        Visual frame = new Visual();
        BallVisualiser visual = new BallVisualiser(frame);
        frame.setVisible(true);
        visual.start();
    }
}
