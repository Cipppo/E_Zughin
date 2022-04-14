package bird.controller;

import javax.swing.JPanel;

import bird.utilities.BirdVisual;
import pangGuy.gui.Shape;

public class BirdRunner extends Thread{
    private final BirdVisual bird;
    private final BirdConstraintCheck checker;

    public BirdRunner(JPanel panel, BirdConstraintCheck checker) {
        this.bird = new BirdVisual(panel);
        this.checker = checker;
    }

    @Override
    public void run() {
        this.bird.run();
    }

    public synchronized void checkCollision(Shape entity) {
        if(this.bird.getActor() != null) {
            if(this.checker.checkEnemyCollision(entity, bird.getActor())) {
                this.bird.getMovementUtils().removeActor();
            }
        }
    }
}
