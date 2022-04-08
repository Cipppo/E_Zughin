package ball.controller;

import java.util.stream.Collectors;

import ball.gui.Updateable;
/**
 * Controller that interfaces Runner with the View
 */
public class BallVisualiser extends Thread {
    private final ConstraintCheck checker;
    private final Updateable frame;
    private final Runner ballRunner;

    public BallVisualiser(Updateable frame) {
        this.frame = frame;
        this.checker = new ConstraintCheck(this.frame.getSize().getWidth(),
                                            this.frame.getSize().getHeight());
        this.ballRunner = new Runner(3, this.checker);
    }

    @Override
    public void run() {
        this.ballRunner.start();
        while(true) {
            try {
                ballRunner.getBalls()
                .forEach(t -> {
                    if (this.checker.checkEnemyCollision(this.frame.getGuy(), t)) {
                        this.ballRunner.duplication(t);
                    }
                    this.frame.updatePosition(this.ballRunner
                                .getBalls()
                                .stream()
                                .map(s -> s.getBallPosition())
                                .collect(Collectors.toList()));
                });
                
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
