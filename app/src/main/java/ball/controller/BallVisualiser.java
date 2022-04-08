package ball.controller;


//toDelete
import java.awt.Dimension;

import ball.gui.Updateable;

/**
 * Controller that interfaces Runner with the View
 */
public class BallVisualiser {
    private final ConstraintCheck checker;
    private final Updateable frame;
    private final Runner ballRunner;

    public BallVisualiser(Updateable frame) {
        this.frame = frame;
        this.checker = new ConstraintCheck(this.frame.getSize().getWidth(),
                                            this.frame.getSize().getHeight());
        this.ballRunner = new Runner(3, this.checker);

    }

    public Dimension getDim() {
        return this.frame.getSize();
    }
}
