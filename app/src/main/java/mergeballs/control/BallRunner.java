package mergeballs.control;

import java.util.stream.Collectors;

import ball.controller.ConstraintCheck;
import mergeballs.gui.VisualTest;
import ball.controller.Runner;


public class BallRunner extends Thread {
    private final ConstraintCheck checker;
    private final UpdateableVisual frame;
    private final Runner ballRunner;

    public BallRunner(VisualTest frame) {
        this.frame = frame;
        this.checker = new ConstraintCheck(this.frame.getBounds().getX(),
                                            this.frame.getBounds().getY());
        this.ballRunner = new Runner(3, this.checker);
    }

    @Override
    public void run() {
        this.ballRunner.start();
        while(true) {
            try {
                ballRunner.getBalls()
                .forEach(t -> {
                    for (final var arp : frame.getArpionsShapes()) {
                        if (this.checker.checkEnemyCollision(arp, t)) {
                            this.ballRunner.duplication(t);
                        } 
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
