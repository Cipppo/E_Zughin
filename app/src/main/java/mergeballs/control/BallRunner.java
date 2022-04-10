package mergeballs.control;

import java.util.stream.Collectors;

import ball.controller.ConstraintCheck;
import mergeballs.gui.VisualTest;

import pangGuy.modularGun.GunSet;
import pangGuy.modularGun.Status;
import pangGuy.utilities.StepsApplier;
import ball.controller.Runner;


public class BallRunner extends Thread {
    private final ConstraintCheck checker;
    private final UpdateableVisual frame;
    private final Runner ballRunner;
    private final GunSet gSet;
    private final StepsApplier stepsConv;
    
    public BallRunner(VisualTest frame, GunSet gSet) {
        this.frame = frame;
        this.checker = new ConstraintCheck(this.frame.getBounds().getX(),
                                            this.frame.getBounds().getY());
        this.ballRunner = new Runner(1, this.checker);

        this.gSet = gSet;
        this.stepsConv = new StepsApplier(this.frame.getStartPos());
    }

    @Override
    public void run() {
        this.ballRunner.start();
        while(true) {
            try {
                ballRunner.getBalls()
                .forEach(t -> {
                    for (final var arp : frame.getArpions()) {
                        if (!arp.getStatus().equals(Status.IDLE)) {
                            if (this.checker.checkEnemyCollision(arp.getShape(), t)) {
                                this.ballRunner.duplication(t);
                                //System.out.println("HIT pos: " + arp.getShape().getPos().y + "steps: " +  (this.stepsConv.fromPixeltoStep(arp.getShape().getPos().y)) );
                                var stepsMade = this.stepsConv.fromPixeltoStep(arp.getShape().getPos().y);
                                this.gSet.getBulletFromSteps(stepsMade).get().hit();
                            } 
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
